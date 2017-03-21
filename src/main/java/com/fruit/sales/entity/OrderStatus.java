package com.fruit.sales.entity;

import org.springframework.stereotype.Component;

@Component
public class OrderStatus {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrderStatus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderStatus [id=" + id + ", name=" + name + "]";
	}

	
}
