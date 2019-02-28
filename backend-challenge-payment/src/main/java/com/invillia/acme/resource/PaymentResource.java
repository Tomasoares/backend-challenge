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

@RestController
@RequestMapping("/payment")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	private static final String paymentId = "paymentId";
	
	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		if (payment.getOrderId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		this.service.create(payment);
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}
	
	@GetMapping("/{" + paymentId + "}")
	public ResponseEntity<Payment> getPayment(@PathParam(paymentId) Integer idPayment) {
		Payment payment = new Payment();
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}
	
	@GetMapping("/{" + paymentId + "}/status")
	public ResponseEntity<PaymentStatus> getPaymentStatus(@PathVariable(paymentId) Integer idPayment) {
		if (idPayment == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		PaymentStatus paymentStatus = this.service.getPaymentStatus(idPayment);
		return ResponseEntity.status(HttpStatus.OK).body(paymentStatus);
	}
	
	@PutMapping("/{" + paymentId + "}/status")
	public ResponseEntity<PaymentStatus> updatePaymentStatus(@PathVariable(paymentId) Integer idPayment, @RequestBody PaymentStatus status) {
		if (idPayment == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		this.service.updatePaymentStatus(idPayment, status);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
}
