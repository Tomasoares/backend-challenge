package com.invillia.acme.service.validators;

import java.util.Date;

import javax.validation.ValidationException;

import org.apache.commons.lang3.time.DateUtils;

import com.invillia.acme.model.PaymentStatus;

public class RefundValidation {
	
	private Date orderConfirmationDate;
	private Date targetDate;
	private PaymentStatus paymentStatus;
	
	public RefundValidation(Date orderConfirmationDate, Date targetDate, PaymentStatus paymentStatus) {
		this.orderConfirmationDate = orderConfirmationDate;
		this.targetDate = targetDate;
		this.paymentStatus = paymentStatus;
	}
	
	public void validate() throws ValidationException {
		Date orderDatePlus10Days = DateUtils.addDays(orderConfirmationDate, 10);
		
		if (paymentStatus != PaymentStatus.PAID) {
			throw new ValidationException("Payment needs to be concluded for refunding!");
		}
		
		if (orderDatePlus10Days.before(targetDate)) {
			throw new ValidationException("Refunds are only allowed within 10 days after confirmation date!");
		}
		
	}
}
