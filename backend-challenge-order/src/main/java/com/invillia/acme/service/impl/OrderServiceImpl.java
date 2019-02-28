package com.invillia.acme.service.impl;


import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Order;
import com.invillia.acme.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private DSLContext jooq;
	
	@Override
	public void create(Order payment) {
		
	}

}
