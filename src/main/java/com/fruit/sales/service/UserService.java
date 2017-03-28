package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.User;

public interface UserService {

	QueryResult<User> list(QueryParam queryParam);
	
	List<User> listAll();
	
	User add(User user);
	
	boolean update(User user);
	
	boolean delete(User user);
	
	User findById(String id);
	
	User findByUsername(String username);
}
