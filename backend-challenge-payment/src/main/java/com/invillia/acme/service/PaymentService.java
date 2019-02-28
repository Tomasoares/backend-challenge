package com.invillia.acme.service;

import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PaymentStatus;

public interface PaymentService {
	
	public void updatePaymentStatus(int idPayment, PaymentStatus status);

	void create(Payment payment);

	PaymentStatus getPaymentStatus(int idPayment);

}
