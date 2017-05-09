package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.OrderAddress;

public interface OrderAddressService {

	List<OrderAddress> findByOpenId(String wechatOpenid);
	
	OrderAddress add(OrderAddress orderAddress);
	
	boolean delete(OrderAddress orderAddress);
	
	boolean deleteById(String id);
	
	OrderAddress findById(String id);

	void setDefaultAddr(String wechatOpenid, String addrId);

	void clearDefaultStatusAddr(String wechatOpeni);

	boolean update(OrderAddress orderAddress);
}
