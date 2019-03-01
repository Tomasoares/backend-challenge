package com.invillia.acme.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderPage {

	private List<Order> orders = new ArrayList<>();
	
	public OrderPage() {
		
	}

	public OrderPage(Order...orders) {
		this.orders.addAll(Arrays.asList(orders));
	}
	
	public OrderPage(List<Order> order) {
		this.orders.addAll(order);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
