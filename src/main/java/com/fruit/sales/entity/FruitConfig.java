package com.fruit.sales.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fruit.sales.entity.base.BaseEntity;

public class FruitConfig extends BaseEntity{

	private String fruitName;
	private Date fruitMonth;
	private Date maxOderDay;
	private String fruitArea;
	private Integer maxOrderNum;
	private Integer maxProvNum;
	private String remark;
	private String extendData;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
	public FruitConfig() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getMaxOderDay() {
		return maxOderDay;
	}

	public void setMaxOderDay(Date maxOderDay) {
		this.maxOderDay = maxOderDay;
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
	
	
	
}
