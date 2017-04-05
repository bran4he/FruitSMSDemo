package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.Order;

public interface OrderService {

	QueryResult<Order> list(QueryParam queryParam);
	
	Order add(Order order);
	
	boolean update(Order order);
	
	boolean delete(Order order);
	
	Order findById(String id);
	
	List<Order> listAll();
}
