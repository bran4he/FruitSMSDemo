package com.fruit.sales.serviceImpl;

import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruit.sales.common.BizTool;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.AssignDetail;
import com.fruit.sales.service.AssignDetailService;
import com.fruit.sales.service.AssignService;

@Service
public class AssignAndDetailService {

	private static final Logger logger = LoggerFactory.getLogger(AssignAndDetailService.class);

	@Autowired
	private AssignDetailService service;
	
	@Autowired
	private AssignService assignService; 
	
	@Transactional
	public AssignDetail handleActiveAdd(AssignDetail ad){
		String phone = ad.getSlavePhone();
		AssignDetail adNew = null;
		
		//phone is exist in Assign, the same logic
		//1.AssignDetail linked to Assign, and save AssignDetail
		//2.Assign unit add AssignDetail part, and save Assign
		if(assignService.hasSlavePhone(phone)){
			Assign assign = assignService.findBySlavePhone(phone);
			//设置关联
			ad.setAssignId(assign.getId());
			//保存ad
			adNew = service.add(ad);
			//增加a
			int balance = assign.getBalanceUnit();
			assign.setBalanceUnit(balance + adNew.getUnitUpdate());
			//更新a
			assignService.update(assign);
		}else{
			//phone is not exist but phone is real
			//1. save Assign with real phone and unit, return id
			//2. link AssignDetail and Assign, save AssignDetail
			if(BusinessConstant.NOT_VIRTUAL.equals(ad.getIsVirtual())){
				//1st - save new record to a - this should be first
				Assign assign = new Assign();
				
				//phone not active
				assign.setIsActive(BusinessConstant.NOT_ACTIVE);
				//update unit
				assign.setBalanceUnit(ad.getUnitUpdate());
				assign.setInitialUnit(ad.getUnitUpdate());
				
				//default
				assign.setEffectivePeriod(BusinessConstant.ASSIGN_DEF_EFF_PERIOD);
				//default
				Date date = new Date(); 
				DateTime dateTime = new DateTime(date).plusYears(assign.getEffectivePeriod());
				assign.setExpireDate(dateTime.toDate());
				
				//default
				assign.setExtendData("");
				assign.setIsVirtual(ad.getIsVirtual());
				//将AD的信息组合起来加入到A的remark
				assign.setRemark(BizTool.genAssRemarkFromAD(ad));
				assign.setSlaveName(ad.getSlaveName());
				//add real phone
				assign.setSlavePhone(phone);
				//default
				assign.setWeecharOpenid(BusinessConstant.DEFAULT_WEECHAT_ID);
				
				Assign assignNew = assignService.add(assign);
				
				//2nd -  save ad
				ad.setAssignId(assignNew.getId());
				adNew = service.add(ad);
				
			//phone is not exist and phone is virtual
			//1. save Assign with 'tempPhone', and return id
			//2. save AssignDetail with a_id and request phone
			//3. update AssignDetail phone with own id
			//4. update Assign phone with ad_id
			}else if(BusinessConstant.IS_VIRTUAL.equals(ad.getIsVirtual())){
				//1st - save new record to a - this should be first
				Assign assign = new Assign();
				
				assign.setBalanceUnit(ad.getUnitUpdate());
				assign.setInitialUnit(ad.getUnitUpdate());
				
				//default
				assign.setEffectivePeriod(BusinessConstant.ASSIGN_DEF_EFF_PERIOD);
				//default
				Date date = new Date(); 
				DateTime dateTime = new DateTime(date).plusYears(assign.getEffectivePeriod());
				assign.setExpireDate(dateTime.toDate());
				//default
				assign.setExtendData("");
				
				assign.setIsVirtual(ad.getIsVirtual());
				//phone not active
				assign.setIsActive(BusinessConstant.NOT_ACTIVE);
				
				//将AD的信息组合起来加入到A的remark
				assign.setRemark(BizTool.genAssRemarkFromAD(ad));
				
				assign.setSlaveName(ad.getSlaveName());
				//temp data
				assign.setSlavePhone("tempPhoneNo");
				//default
				assign.setWeecharOpenid(BusinessConstant.DEFAULT_WEECHAT_ID);
				
				Assign assignNew = assignService.add(assign);
				
				
				//2nd -  save ad
				ad.setAssignId(assignNew.getId());
				adNew = service.add(ad);
				//set salve phone as ad id
				adNew.setSlavePhone(adNew.getId());
				//update ad
				service.update(adNew);
				
				//update a
				assignNew.setSlavePhone(adNew.getId());
				assignService.update(assignNew);
				
			}
		}
		
		return adNew;
	}
}
