package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.dao.PubConfigDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.service.PubConfigService;

@Service
public class PubConfigServiceImpl implements PubConfigService {

	@Autowired
	private PubConfigDao dao;

	@Override
	public QueryResult<PubConfig> list(QueryParam queryParam) {
		// TODO Auto-generated method stub
		return dao.findByPageList(queryParam);
	}
	
	@Override
	public List<PubConfig> listAll() {
		return dao.findAll();
	}

	@Override
	public PubConfig add(PubConfig pubCfg) {
		pubCfg.setId(dao.getNextId());

		pubCfg.setNewDefaultDateAndBy();

		dao.save(pubCfg);
		return pubCfg;
	}

	@Override
	public boolean update(PubConfig pubCfg) {
		pubCfg.setUpdateDefaultDateAndBy();

		dao.update(pubCfg);
		return true;
	}

	@Override
	public boolean delete(PubConfig pubCfg) {
		dao.delete(pubCfg);
		return true;
	}

	@Override
	public PubConfig findById(String id) {
		return dao.findById(id);
	}

	@Override
	public PubConfig findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByFiled("name", name);
	}

}
