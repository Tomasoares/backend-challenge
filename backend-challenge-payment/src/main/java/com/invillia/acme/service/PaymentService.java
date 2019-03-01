package com.invillia.acme.service;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PaymentStatus;

@Service
public interface PaymentService {
	
	void updatePaymentStatus(int orderId, PaymentStatus status);

	void create(Payment payment);

	PaymentStatus getPaymentStatus(int orderId);

	Payment find(Integer paymentId);

}
