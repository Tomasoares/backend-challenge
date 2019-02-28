package com.invillia.acme.model;

import java.util.Date;

public class Payment {

	private Integer id;
	private String creditCard;
	private Date paymentDate;
	private PaymentStatus status;
	private Integer orderId;
	
	public Payment() {
		
	}
	
	public Payment(Integer id, String creditCard, Date paymentDate, PaymentStatus status, Integer orderId) {
		super();
		this.id = id;
		this.creditCard = creditCard;
		this.paymentDate = paymentDate;
		this.status = status;
		this.orderId = orderId;
	}
	
	public Payment(String creditCard, Date paymentDate, PaymentStatus status, Integer orderId) {
		super();
		this.creditCard = creditCard;
		this.paymentDate = paymentDate;
		this.status = status;
		this.orderId = orderId;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
