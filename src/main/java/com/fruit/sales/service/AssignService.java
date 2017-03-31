package com.fruit.sales.service;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.Assign;

public interface AssignService {

	QueryResult<Assign> list(QueryParam queryParam);
	
	Assign add(Assign assign);
	
	boolean update(Assign assign);
	
	boolean delete(Assign assign);
	
	Assign findById(String id);
	
	boolean hasSlavePhone(String phone);
	
	Assign findBySlavePhone(String phone);
}
