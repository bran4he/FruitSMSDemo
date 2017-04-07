package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.PubConfig;

public interface PubConfigService {

	QueryResult<PubConfig> list(QueryParam queryParam);
	
	List<PubConfig> listAll();

	PubConfig add(PubConfig pubCfg);

	boolean update(PubConfig pubCfg);

	boolean delete(PubConfig pubCfg);
	
	PubConfig findById(String id);
	
	PubConfig findByName(String name);
}
