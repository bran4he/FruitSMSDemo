package com.fruit.sales.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fruit.sales.common.DateJsonDeserializer;
import com.fruit.sales.common.DateJsonSerializer;
import com.fruit.sales.common.WebContextHolder;

public class User {

	private String id;	
	
	private String username;
	private String password;
	private String email;
	
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date insertDate;
	
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date updateDate;
	
	private String insertBy;
	private String updateBy;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
//		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

	public User() {
	}
	
	public void setNewDefaultDateAndBy(){
		this.insertDate =  new Date();
		this.updateDate = new Date();
		
		this.insertBy = WebContextHolder.getSessionUsername();
		this.updateBy = WebContextHolder.getSessionUsername();
	}
	
	public void setUpdateDefaultDateAndBy(){
		this.updateDate = new Date();
		
		this.updateBy = WebContextHolder.getSessionUsername();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getInsertBy() {
		return insertBy;
	}
	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

//	public static void main(String[] args) {
//		Field[] fields = User.class.getDeclaredFields();
//		for(Field f:fields){
//			System.out.println(f.getName());
//		}
//	}
}
