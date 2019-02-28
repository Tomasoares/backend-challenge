package com.invillia.acme.model;

public class OrderItem {

	private Integer id;
	private String product;
	private Integer quantity;
	private Double unitPrice;
	
	public OrderItem() {
		
	}

	public OrderItem(String product, Integer quantity, Double unitPrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public OrderItem(Integer id, String product, Integer quantity, Double unitPrice) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
