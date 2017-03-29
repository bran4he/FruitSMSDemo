package com.fruit.sales.service;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.AssignDetail;

public interface AssignDetailService {

	QueryResult<AssignDetail> list(QueryParam queryParam);
	
	AssignDetail add(AssignDetail assignDetail);
	
	boolean update(AssignDetail assignDetail);
	
	boolean delete(AssignDetail assignDetail);
	
	AssignDetail findById(String id);
}
