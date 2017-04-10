package com.fruit.sales.serviceImpl;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.dao.AssignDao;
import com.fruit.sales.dao.PubConfigDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.service.AssignService;

@Service
public class AssignServiceImpl implements AssignService{

	@Autowired
	private AssignDao dao;
	
	@Autowired
	private PubConfigDao pubConfigDao;
	
	@Override
	public QueryResult<Assign> list(QueryParam queryParam) {
		return dao.findByPageList(queryParam);
	}

	@Override
	public Assign add(Assign assign) {
		// TODO Auto-generated method stub
		assign.setId(dao.getNextId());
		
		PubConfig cfg = pubConfigDao.findByFiled("name", BusinessConstant.RECEIVER_EFF_YEAR);
		assign.setEffectivePeriod(Integer.valueOf(cfg.getValue()));
		
		Date date = new Date(); 
		DateTime dateTime = new DateTime(date).plusYears(assign.getEffectivePeriod());
		assign.setExpireDate(dateTime.toDate());
		
		assign.setNewDefaultDateAndBy();
		
		dao.save(assign);
		return assign;
	}

	@Override
	public boolean update(Assign assign) {
		assign.setUpdateDefaultDateAndBy();
		dao.update(assign);
		return true;
	}

	@Override
	public boolean delete(Assign assign) {
		dao.delete(assign);
		return true;
	}

	@Override
	public Assign findById(String id) {
		return dao.findById(id);
	}

	@Override
	public boolean hasSlavePhone(String phone){
		return dao.existSlavePhone(phone);
	}

	@Override
	public Assign findBySlavePhone(String phone) {
		return dao.findByFiled("slavePhone", phone);
	}

	@Override
	public Assign findByWechatId(String wechatId) {
		return dao.findByFiled("wechatOpenid", wechatId);
	}
}
