package com.fruit.sales.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.AssignDetailDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.AssignDetail;
import com.fruit.sales.service.AssignDetailService;

@Service
public class AssignDetailServiceImpl implements AssignDetailService {

	@Autowired
	private AssignDetailDao dao;

	@Override
	public QueryResult<AssignDetail> list(QueryParam queryParam) {
		// TODO Auto-generated method stub
		return dao.findByPageList(queryParam);
	}

	@Override
	public AssignDetail add(AssignDetail user) {
		// TODO Auto-generated method stub
		user.setId(dao.getNextId());

		user.setNewDefaultDateAndBy();

		dao.save(user);
		return user;
	}

	@Override
	public boolean update(AssignDetail user) {
		// TODO Auto-generated method stub
		user.setUpdateDefaultDateAndBy();
		dao.update(user);
		return true;
	}

	@Override
	public boolean delete(AssignDetail user) {
		// TODO Auto-generated method stub
		dao.delete(user);
		return true;
	}

	@Override
	public AssignDetail findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
