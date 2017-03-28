package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.FruitConfigDao;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.service.FruitConfigService;

@Service
public class FruitConfigServiceImpl implements FruitConfigService {

	@Autowired
	private FruitConfigDao fruitConfigDao;
	
	@Override
	public List<FruitConfig> listAll() {
		// TODO Auto-generated method stub
		return fruitConfigDao.findAll();
	}

	@Override
	public FruitConfig add(FruitConfig fruitConfig) {
		// TODO Auto-generated method stub
		fruitConfig.setId(fruitConfigDao.getNextId());
		fruitConfig.setNewDefaultDateAndBy();
		
		fruitConfigDao.save(fruitConfig);
		return fruitConfig;
	}

}
