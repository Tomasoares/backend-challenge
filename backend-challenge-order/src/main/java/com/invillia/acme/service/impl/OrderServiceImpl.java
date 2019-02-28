package com.invillia.acme.service.impl;


import static com.invillia.acme.jooq.tables.Order.ORDER;
import static com.invillia.acme.jooq.tables.OrderItem.ORDER_ITEM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.jooq.tables.records.OrderRecord;
import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderStatus;
import com.invillia.acme.model.PaymentStatus;
import com.invillia.acme.model.filters.OrderGetAllFilters;
import com.invillia.acme.service.OrderItemService;
import com.invillia.acme.service.OrderService;
import com.invillia.acme.service.impl.util.JooqUtils;
import com.invillia.acme.service.validators.RefundValidation;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private DSLContext jooq;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Override
	public void create(Order order) {
		OrderRecord rec = new OrderRecord();
		rec.setAddress(order.getAddress());
		
		if (order.getConfirmationDate() != null) {
			rec.setConfirmationDate(new java.sql.Date(order.getConfirmationDate().getTime()));
		}
		
		if (order.getStatus() != null) {
			rec.setIdOrderStatus(order.getStatus().getId());
		}
		
		rec.setIdStore(order.getId());
		
		rec.attach(this.jooq.configuration());
		rec.store();
		
		order.setId(rec.getId());
	}

	@Override
	public List<Order> getAll(OrderGetAllFilters parameters) {
		//@formatter:off
		SelectQuery<Record> query = this.jooq.select
			()
		.from
			(ORDER)
		.getQuery();
		//@formatter:on
		
		if (parameters != null) {
			if (StringUtils.isNotBlank(parameters.address)) {
				query.addConditions(JooqUtils.like(ORDER.ADDRESS, parameters.address));
			}
			
			if (parameters.confirmationDate != null) {
				query.addConditions(ORDER.CONFIRMATION_DATE.eq(new java.sql.Date(parameters.confirmationDate.getTime())));
			}
			
			if (parameters.idStore != null) {
				query.addConditions(ORDER.ID_STORE.eq(parameters.idStore));
			}
		}
		
		Result<Record> fetch = query.fetch();
		
		List<Order> orders = new ArrayList<>();
		
		if (fetch != null) {
			fetch.forEach(rec -> {
				Order order = new Order();
				
				order.setAddress(rec.getValue(ORDER.ADDRESS));
				order.setConfirmationDate(rec.getValue(ORDER.CONFIRMATION_DATE));
				order.setId(rec.getValue(ORDER.ID));
				order.setStatus(OrderStatus.findById(rec.getValue(ORDER.ID_ORDER_STATUS)));
				
				order.setOrderItems(this.orderItemService.getItems(order.getId()));
				
				orders.add(order);
			});
		}
		
		return orders;
	}

	@Override
	public void refundOrder(int orderId, PaymentStatus paymentStatus) {
		Date orderConfirmationDate = this.getOrderConfirmationDate(orderId);
		new RefundValidation(orderConfirmationDate, new Date(), paymentStatus).validate();
		
		this.doRefund(orderId);
		this.refundAllItems(orderId);
	}

	private Date getOrderConfirmationDate(int orderId) {
		//@formatter:off
		return this.jooq.select
			(ORDER.CONFIRMATION_DATE)
		.from
			(ORDER)
		.where
			(ORDER.ID.eq(orderId))
		.fetchOne().value1();
		//@formatter:on	
	}

	private void doRefund(int orderId) {
		//@formatter:off
		this.jooq.update
			(ORDER)
		.set
			(ORDER.ID_ORDER_STATUS, OrderStatus.REFUNDED.getId())
		.where
			(ORDER_ITEM.ID_ORDER.eq(orderId))
		.execute();
		//@formatter:on
	}

	private void refundAllItems(int orderId) {
		//@formatter:off
		this.jooq.update
			(ORDER_ITEM)
		.set
			(ORDER_ITEM.REFUNDED, true)
		.where
			(ORDER_ITEM.ID_ORDER.eq(orderId))
		.execute();
		//@formatter:on
	}
}
