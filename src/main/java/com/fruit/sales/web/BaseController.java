package com.fruit.sales.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fruit.sales.common.Result;
import com.fruit.sales.dao.base.QueryResult;

public interface BaseController<T> {

	QueryResult<T> list(HttpServletRequest request);
	
	List<T> loadAll();
	
	Result add(T obj);
	
	Result update(T obj);
	
	Result del(String id);
	
}
