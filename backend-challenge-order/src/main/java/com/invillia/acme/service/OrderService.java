package com.invillia.acme.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.PaymentStatus;
import com.invillia.acme.model.filters.OrderGetAllFilters;

@Service
public interface OrderService {
	
	List<Order> getAll(OrderGetAllFilters parameters);

	void create(Order payment);

	void refundOrder(int idOrder, PaymentStatus paymentStatus);

}
