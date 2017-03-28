package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.LoginLog;
import com.fruit.sales.vo.LoginLogVO;

public interface LoginLogService {

	List<LoginLogVO> listAllVO();
	
	QueryResult<LoginLogVO> listVO(QueryParam queryParam);
	
	LoginLog add(LoginLog log);
	
}
