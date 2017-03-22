package com.fruit.sales.serviceImpl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.UserDao;
import com.fruit.sales.entity.User;
import com.fruit.sales.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		user.setId(userDao.getNextId());
		userDao.save(user);
		return user;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		return true;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
		return true;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(username);
	}



}
