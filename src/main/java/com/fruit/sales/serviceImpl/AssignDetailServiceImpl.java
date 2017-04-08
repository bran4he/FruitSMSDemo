package com.fruit.sales.serviceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.dao.AssignDetailDao;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.AssignDetail;
import com.fruit.sales.service.AssignDetailService;

@Service
public class AssignDetailServiceImpl implements AssignDetailService {

	@Autowired
	private AssignDetailDao dao;

	@Override
	public QueryResult<AssignDetail> list(QueryParam queryParam) {
		// TODO Auto-generated method stub
		return dao.findByPageList(queryParam);
	}

	@Override
	public AssignDetail add(AssignDetail assignDetail) {
		// TODO Auto-generated method stub
		assignDetail.setId(dao.getNextId());

		if(StringUtils.isEmpty(assignDetail.getRemark())){
			assignDetail.setRemark(BusinessConstant.DEFAULT_REMARK_DATA);
		}
		
		assignDetail.setNewDefaultDateAndBy();

		dao.save(assignDetail);
		return assignDetail;
	}

	@Override
	public boolean update(AssignDetail assignDetail) {
		// TODO Auto-generated method stub
		assignDetail.setUpdateDefaultDateAndBy();
		dao.update(assignDetail);
		return true;
	}

	@Override
	public boolean delete(AssignDetail assignDetail) {
		// TODO Auto-generated method stub
		dao.delete(assignDetail);
		return true;
	}

	@Override
	public AssignDetail findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
