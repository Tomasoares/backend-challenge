package com.invillia.acme.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.model.Order;
import com.invillia.acme.service.OrderService;

@RestController
@RequestMapping("/payment")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	private static final String paymentId = "paymentId";
	
	@PostMapping
	public ResponseEntity<Order> createPayment(@RequestBody Order order) {
		if (order.getStoreId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		this.service.create(order);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
}
