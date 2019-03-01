package com.invillia.acme.service.impl;


import static com.invillia.acme.jooq.tables.Order.ORDER;
import static com.invillia.acme.jooq.tables.OrderItem.ORDER_ITEM;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.jooq.tables.records.OrderItemRecord;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.OrderStatus;
import com.invillia.acme.model.PaymentStatus;
import com.invillia.acme.service.OrderItemService;
import com.invillia.acme.service.OrderService;
import com.invillia.acme.service.validators.RefundValidation;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private DSLContext jooq;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public void create(OrderItem item, int orderId) {
		OrderItemRecord rec = new OrderItemRecord();
		rec.setIdOrder(orderId);
		rec.setQuantity(item.getQuantity());
		rec.setUnitprice(new BigDecimal(item.getUnitPrice()));
		rec.setRefunded(Boolean.TRUE.equals(item.getRefunded()));
		rec.setDescription(item.getDescription());
		
		rec.attach(this.jooq.configuration());
		rec.store();
		
		item.setId(rec.getId());
	}

	@Override
	public List<OrderItem> getItems(Integer idOrder) {
		//@formatter:off
		return this.jooq.select
			()
		.from
			(ORDER_ITEM)
		.where
			(ORDER_ITEM.ID_ORDER.eq(idOrder))
		.fetch(rec -> {
			OrderItem item = new OrderItem();
			
			item.setId(rec.getValue(ORDER_ITEM.ID));
			item.setDescription(rec.getValue(ORDER_ITEM.DESCRIPTION));
			item.setQuantity(rec.getValue(ORDER_ITEM.QUANTITY));
			item.setRefunded(rec.getValue(ORDER_ITEM.REFUNDED));
			
			BigDecimal unitPrice = rec.getValue(ORDER_ITEM.UNITPRICE);
			item.setUnitPrice(unitPrice != null? unitPrice.doubleValue() : null);
			
			return item;
		});
		//@formatter:off
	}

	@Override
	public void refundItem(int itemId, PaymentStatus status) {
		Date orderConfirmationDate = this.getOrderConfirmationDate(itemId);
		
		new RefundValidation(orderConfirmationDate, orderConfirmationDate, status).validate();
		
		this.doRefund(itemId);
		
		Integer idOrder = getOrderIdFromItem(itemId);
		
		if (this.allItemsRefunded(idOrder)) {
			this.setOrderStatusToRefunded(idOrder);
		}
	}

	private Date getOrderConfirmationDate(int itemId) {
		//@formatter:off
		return this.jooq.select
			(ORDER.CONFIRMATION_DATE)
		.from
			(ORDER_ITEM)
			.join(ORDER)
				.on(ORDER.ID.eq(ORDER_ITEM.ID_ORDER))
		.where
			(ORDER_ITEM.ID.eq(itemId))
		.fetchOne().value1();
		//@formatter:on	
	}

	private void doRefund(int itemId) {
		//@formatter:off
		this.jooq.update
			(ORDER_ITEM)
		.set
			(ORDER_ITEM.REFUNDED, true)
		.where
			(ORDER_ITEM.ID.eq(itemId))
		.execute();
		//@formatter:on
	}

	private Integer getOrderIdFromItem(int itemId) {
		//@formatter:off
		return this.jooq
		.select
			(ORDER_ITEM.ID_ORDER)
		.from
			(ORDER_ITEM)
		.where
			(ORDER_ITEM.ID.eq(itemId))
		.fetchOne().value1();
		//@formatter:on
	}

	private boolean allItemsRefunded(int idOrder) {
		//@formatter:off
		Integer countNotRefunded = this.jooq
			.selectCount()
		.from
			(ORDER_ITEM)
		.where
			(ORDER_ITEM.REFUNDED.isFalse().or(ORDER_ITEM.REFUNDED.isNull()))
			.and(ORDER_ITEM.ID_ORDER.eq(idOrder))
		.fetchOne().value1();
		//@formatter:on
		
		return Objects.equals(countNotRefunded, 0);
	}

	private void setOrderStatusToRefunded(Integer idOrder) {
		this.jooq.update
			(ORDER)
		.set
			(ORDER.ID_ORDER_STATUS, OrderStatus.REFUNDED.getId())
		.where
			(ORDER.ID.eq(idOrder))
		.execute();
	}

}
