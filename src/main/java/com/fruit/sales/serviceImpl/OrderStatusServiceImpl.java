/**
 * 
 */
package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.OrderStatusDaoImpl;
import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.service.OrderStatusService;

/**
 * @author brandon.he
 *
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private OrderStatusDaoImpl orderStatusDao;
	
	@Override
	public List<OrderStatus> listAll() {
		// TODO Auto-generated method stub
		List<OrderStatus> lst = orderStatusDao.getAll();
		return lst;
	}

	@Override
	public boolean add(OrderStatus os) {
		// TODO Auto-generated method stub
		orderStatusDao.insert(os);
		return true;
	}

}
