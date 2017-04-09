package com.fruit.sales.serviceImpl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.common.BusinessConstant;
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
		
		
		
		if(StringUtils.isEmpty(fruitConfig.getRemark())){
			fruitConfig.setRemark(BusinessConstant.DEFAULT_REMARK_DATA);
		}
		if(StringUtils.isEmpty(fruitConfig.getExtendData())){
			fruitConfig.setExtendData(BusinessConstant.DEFAULT_EXTEND_DATA);
		}
		if(null == fruitConfig.getMaxProvNum()){
			fruitConfig.setMaxProvNum(BusinessConstant.DEFAULT_FRUIT_MAX_PROV);
		}
		
		dao.save(fruitConfig);
		return fruitConfig;
	}

	@Override
	public boolean update(FruitConfig fruitConfig) {
		fruitConfig.setUpdateDefaultDateAndBy();

		if(StringUtils.isEmpty(fruitConfig.getRemark())){
			fruitConfig.setRemark(BusinessConstant.DEFAULT_REMARK_DATA);
		}
		if(StringUtils.isEmpty(fruitConfig.getExtendData())){
			fruitConfig.setExtendData(BusinessConstant.DEFAULT_EXTEND_DATA);
		}
		
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
