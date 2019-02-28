package com.invillia.acme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.PaymentStatus;

@Service
public interface OrderItemService {

	void create(OrderItem item, int orderId);

	List<OrderItem> getItems(Integer orderId);

	void refundItem(int itemId, PaymentStatus status);

}
