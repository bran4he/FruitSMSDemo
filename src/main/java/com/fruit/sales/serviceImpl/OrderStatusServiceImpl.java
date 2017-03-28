/**
 * 
 */
package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.OrderStatusDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.service.OrderStatusService;

/**
 * @author brandon.he
 *
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private OrderStatusDao dao;
	
	@Override
	public QueryResult<OrderStatus> list(QueryParam queryParam) {
		// TODO Auto-generated method stub
		return dao.findByPageList(queryParam);
	}
	
	@Override
	public List<OrderStatus> listAll() {
		List<OrderStatus> lst = dao.findAll();
		return lst;
	}

	@Override
	public OrderStatus add(OrderStatus os) {
		os.setId(dao.getNextId());
		
		os.setNewDefaultDateAndBy();
		
		dao.save(os);
		return os;
	}

	@Override
	public boolean update(OrderStatus os) {
		os.setUpdateDefaultDateAndBy();
		
		dao.update(os);
		return true;
	}

	@Override
	public boolean delete(OrderStatus os) {
		dao.delete(os);
		return true;
	}

	@Override
	public OrderStatus findById(String id) {
		return dao.findById(id);
	}

}
