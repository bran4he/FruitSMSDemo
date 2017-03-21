package com.fruit.sales.dao;

import java.util.List;

import com.fruit.sales.entity.OrderStatus;


public interface OrderStatusDao {
	
	OrderStatus get(String id);
	
	List<OrderStatus> getAll();
	
	OrderStatus insert(OrderStatus os);
}
