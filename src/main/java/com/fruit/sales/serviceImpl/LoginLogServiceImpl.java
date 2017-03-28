package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.LoginLogDao;
import com.fruit.sales.entity.LoginLog;
import com.fruit.sales.service.LoginLogService;
import com.fruit.sales.vo.LoginLogVO;

@Service
public class LoginLogServiceImpl implements LoginLogService{

	@Autowired
	private LoginLogDao loginLogDao;
	
	@Override
	public List<LoginLogVO> listAllVO() {
		return loginLogDao.findAllVO();
	}

	@Override
	public LoginLog add(LoginLog log) {
		log.setId(loginLogDao.getNextId());
		
		loginLogDao.save(log);
		return log;
	}

}
