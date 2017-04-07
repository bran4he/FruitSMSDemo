package com.fruit.sales.entity;

public class CommonEntity {

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
	public CommonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommonEntity(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
