package com.invillia.acme.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {

	PROCESSING(1),
	PAID(2),
	REFUSED(3),
	CANCELLED(4);
	
	private int id;

	PaymentStatus(int id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}
	
	@JsonValue
	public String getPaymentStatus() {
		return this.name();
	}
	
	public static PaymentStatus findById(int id) {
		for (PaymentStatus payment : PaymentStatus.values()) {
			if (Objects.equals(id, payment.id)) {
				return payment;
			}
		}
		
		return null;
	}
	
}
