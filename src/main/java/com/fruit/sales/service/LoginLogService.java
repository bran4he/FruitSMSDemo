package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.LoginLog;

public interface LoginLogService {

	List<LoginLog> listAll();
	
	LoginLog add(LoginLog log);
	
}
