package com.invillia.acme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Integer id;
	private Integer storeId;
	private Date confirmationDate;
	private String address;
	private OrderStatus status;
	
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(Integer id, Integer storeId, Date creationDate, String address, List<OrderItem> orderItems, OrderStatus status) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.confirmationDate = creationDate;
		this.address = address;
		this.orderItems = orderItems;
		this.status = status;
	}
	
	public Order(Integer storeId, Date creationDate, String address, List<OrderItem> orderItems, OrderStatus status) {
		super();
		this.storeId = storeId;
		this.confirmationDate = creationDate;
		this.address = address;
		this.orderItems = orderItems;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Object getStoreId() {
		return this.storeId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
