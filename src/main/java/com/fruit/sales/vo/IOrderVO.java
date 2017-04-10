package com.fruit.sales.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fruit.sales.common.DateJsonDeserializer;
import com.fruit.sales.common.DateJsonSerializer;
import com.fruit.sales.common.WebContextHolder;

public class IOrderVO {


	private String id;
	

	//fk
	private String statusId;
	private String statusValue;
	
	//fk
	private String assignId;
	private String wechatOpenid;
	
	
	private Integer orderUnit;
	
	//fk
	private String fruitId;
	private String fruitName;
	
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date planDeliveryDate;
	private String address;
	private String contactName;
	private String contactPhone;

	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date deliveryDate;
	private String deliveryBy;
	private String deliveryRemark;

	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date finishDate;
	private String finishBy;
	private String finishRemark;

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
	
	
	
	

	public IOrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
//		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
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

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getAssignId() {
		return assignId;
	}

	public void setAssignId(String assignId) {
		this.assignId = assignId;
	}

	public Date getPlanDeliveryDate() {
		return planDeliveryDate;
	}

	public void setPlanDeliveryDate(Date planDeliveryDate) {
		this.planDeliveryDate = planDeliveryDate;
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryBy() {
		return deliveryBy;
	}

	public void setDeliveryBy(String deliveryBy) {
		this.deliveryBy = deliveryBy;
	}

	public String getDeliveryRemark() {
		return deliveryRemark;
	}

	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getFinishBy() {
		return finishBy;
	}

	public void setFinishBy(String finishBy) {
		this.finishBy = finishBy;
	}

	public String getFinishRemark() {
		return finishRemark;
	}

	public void setFinishRemark(String finishRemark) {
		this.finishRemark = finishRemark;
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

	public Integer getOrderUnit() {
		return orderUnit;
	}

	public void setOrderUnit(Integer orderUnit) {
		this.orderUnit = orderUnit;
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

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public String getWechatOpenid() {
		return wechatOpenid;
	}

	public void setWechatOpenid(String wechatOpenid) {
		this.wechatOpenid = wechatOpenid;
	}

}
