package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.OrderAddressDao;
import com.fruit.sales.entity.OrderAddress;
import com.fruit.sales.service.OrderAddressService;

@Service
public class OrderAddressServiceImpl implements OrderAddressService {

	@Autowired
	private OrderAddressDao dao;
	
	@Override
	public List<OrderAddress> findByOpenId(String wechatOpenid) {
		return dao.findListByFiled("wechatOpenid", wechatOpenid);
	}

	@Override
	public OrderAddress add(OrderAddress orderAddress) {
		orderAddress.setId(dao.getNextId());
		dao.save(orderAddress);
		return orderAddress;
	}

	@Override
	public boolean delete(OrderAddress orderAddress) {
		dao.delete(orderAddress);
		return (findById(orderAddress.getId()) != null)? false : true;
	}

	@Override
	public OrderAddress findById(String id) {
		return dao.findById(id);
	}

	@Override
	public boolean deleteById(String id) {
		dao.delete(id);
		return (findById(id) != null)? false : true;
	}


}
