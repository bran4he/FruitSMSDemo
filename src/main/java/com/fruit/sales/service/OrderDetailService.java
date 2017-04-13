package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.OrderDetail;

public interface OrderDetailService {

	int findMaxOrderUnitByFruitId(String fruitId);
	
	int addBatch(List<OrderDetail> lst);
	
	List<OrderDetail> findByOrderId(String orderId);
}
