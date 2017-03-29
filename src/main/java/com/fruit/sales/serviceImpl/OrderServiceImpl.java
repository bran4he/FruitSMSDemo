package com.fruit.sales.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.OrderDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.Order;
import com.fruit.sales.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;
	
	@Override
	public QueryResult<Order> list(QueryParam queryParam) {
		return dao.findByPageList(queryParam);
	}

	@Override
	public Order add(Order order) {
		// TODO Auto-generated method stub
		order.setId(dao.getNextId());
		
		order.setNewDefaultDateAndBy();
		
		dao.save(order);
		return order;
	}

	@Override
	public boolean update(Order order) {
		order.setUpdateDefaultDateAndBy();
		dao.update(order);
		return true;
	}

	@Override
	public boolean delete(Order order) {
		dao.delete(order);
		return true;
	}

	@Override
	public Order findById(String id) {
		return dao.findById(id);
	}
}
