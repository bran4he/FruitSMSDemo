package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.OrderStatus;

public interface OrderStatusService {

	QueryResult<OrderStatus> list(QueryParam queryParam);
	
	List<OrderStatus> listAll();
	
	OrderStatus add(OrderStatus os);
	
	boolean update(OrderStatus os);
	
	boolean delete(OrderStatus os);
	
	OrderStatus findById(String id);
	
}
