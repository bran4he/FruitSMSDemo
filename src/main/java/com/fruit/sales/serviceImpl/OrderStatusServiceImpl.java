/**
 * 
 */
package com.fruit.sales.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.OrderStatusDao;
import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.service.OrderStatusService;

/**
 * @author brandon.he
 *
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private OrderStatusDao orderStatusDao;
	
	@Override
	public List<OrderStatus> listAll() {
		List<OrderStatus> lst = orderStatusDao.findAll();
		return lst;
	}

	@Override
	public OrderStatus add(OrderStatus os) {
		os.setId(orderStatusDao.getNextId());
		
		os.setNewDefaultDateAndBy();
		
		orderStatusDao.save(os);
		return os;
	}

	@Override
	public boolean update(OrderStatus os) {
		os.setUpdateDefaultDateAndBy();
		
		orderStatusDao.update(os);
		return true;
	}

	@Override
	public boolean delete(OrderStatus os) {
		orderStatusDao.delete(os);
		return true;
	}

	@Override
	public OrderStatus findById(String id) {
		return orderStatusDao.findById(id);
	}

}
