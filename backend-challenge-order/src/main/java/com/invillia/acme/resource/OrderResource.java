package com.invillia.acme.resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderPage;
import com.invillia.acme.model.PaymentStatus;
import com.invillia.acme.model.filters.OrderGetAllFilters;
import com.invillia.acme.service.OrderItemService;
import com.invillia.acme.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderItemService serviceItem;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public ResponseEntity<Order> createPayment(@RequestBody Order order) {
		if (order.getStoreId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		this.service.create(order);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> get(@PathVariable("orderId") Integer orderId) {
		
		Order result = this.service.get(orderId);
		
		if (result == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping
	public ResponseEntity<OrderPage> getAll(@RequestParam(required = false) Date confirmationDate, 
			  								@RequestParam(required = false) String address,
			  								@RequestParam(required = false) Integer idStore) {
		
		OrderGetAllFilters parameters = new OrderGetAllFilters();
		parameters.address = address;
		parameters.confirmationDate = confirmationDate;
		parameters.idStore = idStore;
		
		List<Order> orders = this.service.getAll(parameters);
		
		if (orders.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(new OrderPage(orders));
	}
	
	@PutMapping("/{orderId}/refund")
	public ResponseEntity<String> refundOrder(@PathVariable("orderId") Integer orderId) {
		try {
			PaymentStatus paymentStatus = this.getPaymentStatus(orderId);
			this.service.refundOrder(orderId, paymentStatus);
			
			return ResponseEntity.status(HttpStatus.OK).body(null);
			
		} catch (ValidationException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/{orderId}/orderItens/{orderItemId}/refund")
	public ResponseEntity<Object> refundOrderItem(@PathVariable("orderId") Integer orderId,
												  @PathVariable("orderItemId") Integer orderItemId) {
		try {
			PaymentStatus paymentStatus = this.getPaymentStatus(orderId);
			this.serviceItem.refundItem(orderItemId, paymentStatus);
			
			return ResponseEntity.status(HttpStatus.OK).body(null);
			
		} catch (ValidationException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	private PaymentStatus getPaymentStatus(Integer orderId) {
		String url = "http://acme-payment/orders/{orderId}/payments/status";
		
		Map<String, Object> params = new HashMap<>();
		params.put("orderId", orderId);
		
		ResponseEntity<PaymentStatus> response = restTemplate.getForEntity(url, PaymentStatus.class, params);
		return response.getBody();
	}
	
}
