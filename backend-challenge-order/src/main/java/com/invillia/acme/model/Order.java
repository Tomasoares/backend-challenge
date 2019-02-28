package com.invillia.acme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Integer id;
	private Integer storeId;
	private Date creationDate;
	private String address;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(Integer id, Integer storeId, Date creationDate, String address, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.creationDate = creationDate;
		this.address = address;
		this.orderItems = orderItems;
	}
	
	public Order(Integer storeId, Date creationDate, String address, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.creationDate = creationDate;
		this.address = address;
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

}
