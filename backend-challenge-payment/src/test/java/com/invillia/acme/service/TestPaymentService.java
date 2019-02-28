package com.invillia.acme.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PaymentStatus;
import com.invillia.acme.service.PaymentService;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureJooq
public class TestPaymentService {

	@Autowired
	private PaymentService service;
	
	@Autowired
	private DSLContext jooq;
	
	@Test
	public void testNewPayment() throws Exception {
		Payment payment = new Payment("237468237", new Date(), PaymentStatus.PROCESSING, 1);
		service.create(payment);
		
		assertNotNull(payment.getId());
	}
	
	@Test
	public void testGetPaymentStatus() throws Exception {
		Payment payment = new Payment("65765787656", new Date(), PaymentStatus.REFUSED, 1);
		service.create(payment);
		
		PaymentStatus paymentStatus = service.getPaymentStatus(payment.getId());
		assertEquals(payment.getStatus(), paymentStatus);
	}
	
	@Test
	public void testSetPaymentStatus() throws Exception {
		Payment payment = new Payment("84793248572", new Date(), PaymentStatus.REFUSED, 1);
		service.create(payment);
		
		service.updatePaymentStatus(payment.getId(), PaymentStatus.CONCLUDED);
		PaymentStatus paymentStatus = service.getPaymentStatus(payment.getId());
		
		assertEquals(PaymentStatus.CONCLUDED, paymentStatus);
	}
	
}
