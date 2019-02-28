package com.invillia.acme.model;

public class Store {

	private Integer id;
	private String name;
	private String code;
	private String address;
	
	public Store() {
		
	}
	
	public Store(Integer id, String name, String code, String address) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String nome) {
		this.name = nome;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
