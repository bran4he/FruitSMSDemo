package com.fruit.sales.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fruit.sales.common.DateJsonDeserializer;
import com.fruit.sales.common.DateJsonSerializer;
import com.fruit.sales.common.WebContextHolder;

public class FruitConfig {

	private String id;

	private String fruitName;

	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date fruitMonth;

	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date maxOrderDay;

	private String fruitArea;
	private Integer maxOrderNum;
	private Integer maxProvNum;
	private Integer balanceNum;
	private String remark;
	private String extendData;

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
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.JSON_STYLE);
	}

	public FruitConfig() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public Date getFruitMonth() {
		return fruitMonth;
	}

	public void setFruitMonth(Date fruitMonth) {
		this.fruitMonth = fruitMonth;
	}

	public Date getMaxOrderDay() {
		return maxOrderDay;
	}

	public void setMaxOrderDay(Date maxOrderDay) {
		this.maxOrderDay = maxOrderDay;
	}

	public String getFruitArea() {
		return fruitArea;
	}

	public void setFruitArea(String fruitArea) {
		this.fruitArea = fruitArea;
	}

	public Integer getMaxOrderNum() {
		return maxOrderNum;
	}

	public void setMaxOrderNum(Integer maxOrderNum) {
		this.maxOrderNum = maxOrderNum;
	}

	public Integer getMaxProvNum() {
		return maxProvNum;
	}

	public void setMaxProvNum(Integer maxProvNum) {
		this.maxProvNum = maxProvNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExtendData() {
		return extendData;
	}

	public void setExtendData(String extendData) {
		this.extendData = extendData;
	}

	public Integer getBalanceNum() {
		return balanceNum;
	}

	public void setBalanceNum(Integer balanceNum) {
		this.balanceNum = balanceNum;
	}

	
}
