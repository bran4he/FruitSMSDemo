package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.OrderStatus;

public interface OrderStatusService {

	List<OrderStatus> listAll();
	
	boolean add(OrderStatus os);
}
