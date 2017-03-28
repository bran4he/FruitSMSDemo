package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.FruitConfig;

public interface FruitConfigService {
	
	List<FruitConfig> listAll();
	
	FruitConfig add(FruitConfig fruitConfig);
}
