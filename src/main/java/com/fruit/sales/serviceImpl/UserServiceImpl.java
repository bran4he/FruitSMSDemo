package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.UserDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.User;
import com.fruit.sales.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public QueryResult<User> list(QueryParam queryParam) {
		// TODO Auto-generated method stub
		return dao.findByPageList(queryParam);
	}
	
	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		user.setId(dao.getNextId());
		
		user.setNewDefaultDateAndBy();
		
		dao.save(user);
		return user;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		user.setUpdateDefaultDateAndBy();
		dao.update(user);
		return true;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		dao.delete(user);
		return true;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findUserByName(username);
	}





}
