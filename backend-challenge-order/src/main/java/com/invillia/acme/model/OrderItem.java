package com.invillia.acme.model;

public class OrderItem {

	private Integer id;
	private String description;
	private Integer quantity;
	private Double unitPrice;
	private Boolean refunded;
	
	public OrderItem() {
		
	}

	public OrderItem(String description, Integer quantity, Double unitPrice) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public OrderItem(Integer id, String description, Integer quantity, Double unitPrice) {
		super();
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getRefunded() {
		return refunded;
	}

	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}
}
