package com.invillia.acme.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {

	OPEN(1),
	FINISHED(2),
	CANCELLED(3),
	REFUNDED(4);
	
	private int id;

	OrderStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@JsonValue
	public String getOrderStatus() {
		return this.name();
	}
	
	public static OrderStatus findById(int id) {
		for (OrderStatus order : OrderStatus.values()) {
			if (Objects.equals(id, order.id)) {
				return order;
			}
		}
		
		return null;
	}
}
