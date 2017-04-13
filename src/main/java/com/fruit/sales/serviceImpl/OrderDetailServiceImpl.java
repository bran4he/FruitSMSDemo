package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.OrderDetailDao;
import com.fruit.sales.entity.OrderDetail;
import com.fruit.sales.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao dao;
	
	@Override
	public int findMaxOrderUnitByFruitId(String fruitId) {
		return dao.findMaxOrderUnitByFruitId(fruitId);
	}

	@Override
	public int addBatch(List<OrderDetail> lst) {
		
		return dao.addOrderDetailList(lst);
	}

	@Override
	public List<OrderDetail> findByOrderId(String orderId) {
		return dao.findListByFiled("orderId", orderId);
	}
}
