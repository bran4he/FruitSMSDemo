package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.FruitConfigDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.service.FruitConfigService;

@Service
public class FruitConfigServiceImpl implements FruitConfigService {

	@Autowired
	private FruitConfigDao dao;
	
	@Override
	public QueryResult<FruitConfig> list(QueryParam queryParam) {
		// TODO Auto-generated method stub
		return dao.findByPageList(queryParam);
	}
	
	@Override
	public List<FruitConfig> listAll() {
		
		return dao.findAll();
	}

	@Override
	public FruitConfig add(FruitConfig fruitConfig) {
		fruitConfig.setId(dao.getNextId());
		fruitConfig.setNewDefaultDateAndBy();
		
		dao.save(fruitConfig);
		return fruitConfig;
	}

	@Override
	public boolean update(FruitConfig fruitConfig) {
		fruitConfig.setUpdateDefaultDateAndBy();

		dao.update(fruitConfig);
		return true;
	}

	@Override
	public boolean delete(FruitConfig fruitConfig) {
		dao.delete(fruitConfig);
		return (findById(fruitConfig.getId()) != null)? false : true;
	}

	@Override
	public FruitConfig findById(String id) {
		return dao.findById(id);
	}

}
