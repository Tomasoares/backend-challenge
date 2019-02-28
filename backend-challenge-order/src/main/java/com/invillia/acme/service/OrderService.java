package com.invillia.acme.service;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.Order;

@Service
public interface OrderService {
	
	void create(Order order);

}
