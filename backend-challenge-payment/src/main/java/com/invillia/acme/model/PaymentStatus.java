package com.invillia.acme.model;

import java.util.Objects;

public enum PaymentStatus {

	PROCESSING(1),
	CONCLUDED(2),
	REFUSED(3),
	CANCELED(4);
	
	private int id;

	PaymentStatus(int id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
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
