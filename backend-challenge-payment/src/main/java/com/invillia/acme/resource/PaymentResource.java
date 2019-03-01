package com.invillia.acme.resource;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PaymentStatus;
import com.invillia.acme.service.PaymentService;

import static com.invillia.acme.resource.PaymentResource.ORDER_ID;

@RestController
@RequestMapping("orders/{" + ORDER_ID + "}/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	static final String PAYMENT_ID = "paymentId";
	static final String ORDER_ID = "orderId";
	
	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		if (payment.getOrderId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		this.service.create(payment);
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}
	
	@GetMapping("/{" + PAYMENT_ID + "}")
	public ResponseEntity<Payment> getPayment(@PathParam(PAYMENT_ID) Integer paymentId) {
		Payment payment = new Payment();
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}
	
	@GetMapping("/status")
	public ResponseEntity<PaymentStatus> getPaymentStatus(@PathVariable(ORDER_ID) Integer orderId) {
		if (orderId == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		PaymentStatus paymentStatus = this.service.getPaymentStatus(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(paymentStatus);
	}
	
	@PutMapping("/{" + PAYMENT_ID +"}/status")
	public ResponseEntity<PaymentStatus> updatePaymentStatus(@PathVariable(PAYMENT_ID) Integer paymentId, @RequestBody PaymentStatus status) {
		if (paymentId == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		this.service.updatePaymentStatus(paymentId, status);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
}
