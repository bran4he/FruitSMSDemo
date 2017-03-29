package com.fruit.sales.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fruit.sales.common.DateJsonDeserializer;
import com.fruit.sales.common.DateJsonSerializer;

public class LoginLog {

	private String id;
	private String userId;
	
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date loginDate;
	
	private String loginIP;
	
	public LoginLog() {
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
	public LoginLog(String id, String userId, Date loginDate, String loginIP) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginDate = loginDate;
		this.loginIP = loginIP;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	
	
}
