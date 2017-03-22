package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.OrderStatus;

public interface OrderStatusService {

	List<OrderStatus> listAll();
	
	OrderStatus add(OrderStatus os);
	
	boolean update(OrderStatus os);
	
	boolean delete(OrderStatus os);
	
	OrderStatus findById(String id);
	
}
