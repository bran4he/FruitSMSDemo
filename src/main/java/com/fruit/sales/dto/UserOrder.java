package com.fruit.sales.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
{
"fruitList":{
    [
    "fruitId": 1,
    "fruitName": "apple0",
    "orderUnit": 1
    ],
    [
    "fruitId": 2,
    "fruitName": "banana",
    "orderUnit": 2
    ]
},
"address": "中国上海市淞沪路270号创智天地广场3号楼",
"contactName": "王小二",
"contactPhone": "15888888888",
"remark":"remark"
}
*/
public class UserOrder {

	private String address;
	private String contactName;
	private String contactPhone;
	private String remark;
	
	private List<FruitOrder> fruitList;
	
	public int getTotalUnit(){
		if(fruitList != null && fruitList.size() > 0){
			int total = fruitList.stream().mapToInt(it -> it.getOrderUnit()).sum();
			return total;
		}else{
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<FruitOrder> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<FruitOrder> fruitList) {
		this.fruitList = fruitList;
	}

	
}
