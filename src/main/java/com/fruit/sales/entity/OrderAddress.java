package com.fruit.sales.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrderAddress {

	private String id;	
	
	private String address;
	private String contactName;
	private String contactPhone;
	private String wechatOpenid;

	/**is default address, and default is 0-No**/
	private Integer defaultAddr;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderAddress that = (OrderAddress) o;

		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
		if (contactPhone != null ? !contactPhone.equals(that.contactPhone) : that.contactPhone != null) return false;
		return wechatOpenid != null ? wechatOpenid.equals(that.wechatOpenid) : that.wechatOpenid == null;
	}

	@Override
	public int hashCode() {
		int result = address != null ? address.hashCode() : 0;
		result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
		result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
		result = 31 * result + (wechatOpenid != null ? wechatOpenid.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

	public OrderAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getWechatOpenid() {
		return wechatOpenid;
	}

	public void setWechatOpenid(String wechatOpenid) {
		this.wechatOpenid = wechatOpenid;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Integer getDefaultAddr() {
		return defaultAddr;
	}

	public void setDefaultAddr(Integer defaultAddr) {
		this.defaultAddr = defaultAddr;
	}
}
