package com.fruit.sales.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
	"fruitId": 1,
	"fruitName": "apple0",
	"orderUnit": 1,
	"address": "中国上海市淞沪路270号创智天地广场3号楼",
	"contactName": "王小二",
	"contactPhone": "15888888888",
	"remark":"remark"
 */
public class FruitOrder {
	
	private String fruitId;
	private String fruitName;
	private Integer orderUnit;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
	
	public String getFruitId() {
		return fruitId;
	}
	public void setFruitId(String fruitId) {
		this.fruitId = fruitId;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public Integer getOrderUnit() {
		return orderUnit;
	}
	public void setOrderUnit(Integer orderUnit) {
		this.orderUnit = orderUnit;
	}


	
	
}
