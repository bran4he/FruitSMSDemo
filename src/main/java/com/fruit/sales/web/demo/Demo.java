package com.fruit.sales.web.demo;

public class Demo {

	private String id;
	private String name;
	private Integer age;
	private String sex;

	
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Demo(String name, Integer age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public Demo(String id, String name, Integer age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", age=" + age + ", sex="
				+ sex + "]";
	}
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
