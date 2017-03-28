package com.fruit.sales.entity.base;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fruit.sales.common.DateJsonDeserializer;
import com.fruit.sales.common.DateJsonSerializer;
import com.fruit.sales.common.WebContextHolder;

public class BaseEntity {

	private String id;
	
	//for spring mvc directly
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date insertDate;
	
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date updateDate;
	
	private String insertBy;
	private String updateBy;
	
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
	
	
}
