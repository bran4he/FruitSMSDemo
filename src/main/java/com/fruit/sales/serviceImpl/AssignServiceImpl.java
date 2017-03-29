package com.fruit.sales.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.AssignDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.service.AssignService;

@Service
public class AssignServiceImpl implements AssignService{

	@Autowired
	private AssignDao dao;
	
	@Override
	public QueryResult<Assign> list(QueryParam queryParam) {
		return dao.findByPageList(queryParam);
	}

	@Override
	public Assign add(Assign assign) {
		// TODO Auto-generated method stub
		assign.setId(dao.getNextId());
		
		assign.setNewDefaultDateAndBy();
		
		dao.save(assign);
		return assign;
	}

	@Override
	public boolean update(Assign assign) {
		assign.setUpdateDefaultDateAndBy();
		dao.update(assign);
		return true;
	}

	@Override
	public boolean delete(Assign assign) {
		dao.delete(assign);
		return true;
	}

	@Override
	public Assign findById(String id) {
		return dao.findById(id);
	}

}
