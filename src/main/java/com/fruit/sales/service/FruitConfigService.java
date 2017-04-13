package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.FruitConfig;

public interface FruitConfigService {
	
	QueryResult<FruitConfig> list(QueryParam queryParam);
	
	List<FruitConfig> listAll();
	
	List<FruitConfig> listCurrentMonthFruit();
	
	FruitConfig add(FruitConfig fruitConfig);
	
	boolean update(FruitConfig fruitConfig);
	
	boolean delete(FruitConfig fruitConfig);
	
	FruitConfig findById(String id);
	
	
}
