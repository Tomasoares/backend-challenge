package com.invillia.acme.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.Date;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PaymentStatus;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureJooq
@Transactional 
public class TestPaymentService {

	@Autowired
	private PaymentService service;
	
	@Autowired
	private DSLContext jooq;
	
	@Test
	public void testNewPayment() throws Exception {
		Payment payment = new Payment("237468237", new Date(), PaymentStatus.PROCESSING, any());
		service.create(payment);
		
		assertNotNull("Insert a payment with .create(payment) method", payment.getId());
	}
	
	@Test
	public void testGetPaymentStatus() throws Exception {
		Payment payment = new Payment("65765787656", new Date(), PaymentStatus.REFUSED, 1);
		service.create(payment);
		
		PaymentStatus paymentStatus = service.getPaymentStatus(1);
		assertEquals("Look up for paymentStatus with .getPaymentStatus(id) method", payment.getStatus(), paymentStatus);
	}
	
	@Test
	public void testSetPaymentStatus() throws Exception {
		Payment payment = new Payment("84793248572", new Date(), PaymentStatus.REFUSED, 1);
		service.create(payment);
		
		service.updatePaymentStatus(payment.getId(), PaymentStatus.PAID);
		PaymentStatus paymentStatus = service.getPaymentStatus(1);
		
		assertEquals("update paymentStatus with .updatePaymentStatus(id, status) method", PaymentStatus.PAID, paymentStatus);
	}
	
}
