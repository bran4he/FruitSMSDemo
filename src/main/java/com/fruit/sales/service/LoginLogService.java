package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.LoginLog;
import com.fruit.sales.vo.LoginLogVO;

public interface LoginLogService {

	List<LoginLogVO> listAllVO();
	
	LoginLog add(LoginLog log);
	
}
