package com.fruit.sales.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.dao.PubConfigDao;
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.service.PubConfigService;

@Service
public class PubConfigServiceImpl implements PubConfigService {

	@Autowired
	private PubConfigDao pubCfgDao;

	@Override
	public List<PubConfig> listAll() {
		return pubCfgDao.findAll();
	}

	@Override
	public PubConfig add(PubConfig pubCfg) {
		pubCfg.setId(pubCfgDao.getNextId());

		pubCfg.setNewDefaultDateAndBy();

		pubCfgDao.save(pubCfg);
		return pubCfg;
	}

	@Override
	public boolean update(PubConfig pubCfg) {
		pubCfg.setUpdateDefaultDateAndBy();

		pubCfgDao.update(pubCfg);
		return true;
	}

	@Override
	public boolean delete(PubConfig pubCfg) {
		pubCfgDao.delete(pubCfg);
		return true;
	}

	@Override
	public PubConfig findById(String id) {
		return pubCfgDao.findById(id);
	}

}
