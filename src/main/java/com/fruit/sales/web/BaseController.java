package com.fruit.sales.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fruit.sales.common.Result;
import com.fruit.sales.dao.base.QueryResult;

public interface BaseController<T> {

	//规定命名，每个模块的首页
	String index();
	
	QueryResult<T> list(HttpServletRequest request);
	
	List<T> loadAll();
	
	Result add(T obj);
	
	Result update(T obj);
	
	Result del(String id);
	
}
