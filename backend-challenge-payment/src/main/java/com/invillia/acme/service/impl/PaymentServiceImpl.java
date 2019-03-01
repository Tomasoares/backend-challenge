package com.invillia.acme.service.impl;

import static com.invillia.acme.jooq.tables.Payment.PAYMENT;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.jooq.tables.records.PaymentRecord;
import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PaymentStatus;
import com.invillia.acme.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private DSLContext jooq;
	
	@Override
	public void create(Payment payment) {
		PaymentRecord rec = new PaymentRecord();
		rec.setCreditCard(payment.getCreditCard());
		rec.setIdPaymentStatus(payment.getStatus().getId());
		rec.setPaymentDate(new java.sql.Timestamp(payment.getPaymentDate().getTime()));
		
		rec.attach(this.jooq.configuration());
		rec.store();

		payment.setId(rec.getId());
	}

	@Override
	public PaymentStatus getPaymentStatus(int orderId) {
		//@formatter:off
		Record1<Integer> rec = this.jooq
				.select
					(PAYMENT.ID_PAYMENT_STATUS)
				.from
					(PAYMENT)
				.where
					(PAYMENT.ID_ORDER.eq(orderId))
				.orderBy
					(PAYMENT.ID.desc())
				.limit
					(1)
				.fetchOne();
		//@formatter:on
		
		return rec!= null? PaymentStatus.findById(rec.value1()) : null;
	}

	@Override
	public void updatePaymentStatus(int idPayment, PaymentStatus status) {
		//@formatter:off
		this.jooq.update
			(PAYMENT)
		.set
			(PAYMENT.ID_PAYMENT_STATUS, status.getId())
		.where
			(PAYMENT.ID.eq(idPayment))
		.execute();
		//@formatter:on
		
	}

}
