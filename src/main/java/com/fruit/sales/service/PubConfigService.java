package com.fruit.sales.service;

import java.util.List;

import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.entity.PubConfig;

public interface PubConfigService {

	List<PubConfig> listAll();

	PubConfig add(PubConfig pubCfg);

	boolean update(PubConfig pubCfg);

	boolean delete(PubConfig pubCfg);
	
	PubConfig findById(String id);
}
