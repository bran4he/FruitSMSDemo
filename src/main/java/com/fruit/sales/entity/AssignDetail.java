package com.fruit.sales.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fruit.sales.common.DateJsonDeserializer;
import com.fruit.sales.common.DateJsonSerializer;
import com.fruit.sales.common.WebContextHolder;

public class AssignDetail {

	private String id;	
	
	private Integer assignId;
	private Integer unitUpdate;
	
	
	private String masterPhone;
	private String masterName;
	private String slavePhone;
	private String slaveName;
	
	private String remark;
	
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date insertDate;
	
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	private Date updateDate;
	
	private String insertBy;
	private String updateBy;

	
	
	public AssignDetail() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
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



	public Integer getAssignId() {
		return assignId;
	}



	public void setAssignId(Integer assignId) {
		this.assignId = assignId;
	}



	public String getMasterPhone() {
		return masterPhone;
	}



	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}



	public String getMasterName() {
		return masterName;
	}



	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}



	public String getSlavePhone() {
		return slavePhone;
	}



	public void setSlavePhone(String slavePhone) {
		this.slavePhone = slavePhone;
	}



	public String getSlaveName() {
		return slaveName;
	}



	public void setSlaveName(String slaveName) {
		this.slaveName = slaveName;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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



	public Integer getUnitUpdate() {
		return unitUpdate;
	}



	public void setUnitUpdate(Integer unitUpdate) {
		this.unitUpdate = unitUpdate;
	}
	
	
	
}
