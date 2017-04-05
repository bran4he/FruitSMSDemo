package com.fruit.sales.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.common.BizTool;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.common.Result;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.dao.base.QueryUtil;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.AssignDetail;
import com.fruit.sales.service.AssignDetailService;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.web.base.BaseController;

@Controller
@RequestMapping("/assignDetail")
public class AssignDetailController implements BaseController<AssignDetail> {

	private static final Logger logger = LoggerFactory.getLogger(AssignDetailController.class);

	@Autowired
	private AssignDetailService service;
	
	@Autowired
	private AssignService assignService; 

	// 规定命名，每个模块的首页
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "assignDetail";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<AssignDetail> list(
			HttpServletRequest request) {

		QueryParam queryParam = QueryUtil.getQueryParam(request);

		return service.list(queryParam);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody AssignDetail ad) {
		
		logger.info("AssignDetail request:\n ?", ad.toString());
		
		AssignDetail adNew = null;
		adNew = handleActiveAdd(ad);
		
		Map<String, Object> data = new HashMap<String, Object>();
		if (adNew != null) {
			data.put("data", adNew);
			return new Result(true, data);
		} else {
			return new Result(false, data);
		}
	}
	
	private AssignDetail handleActiveAdd(AssignDetail ad){
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
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id) {
//		AssignDetail u = service.findById(id);
//		Map<String, Object> data = new HashMap<String, Object>();
//		boolean flag = service.delete(u);
//		if (flag) {
//			data.put("data", u);
//			return new Result(true, data);
//		}
//		return new Result(flag, data);
		return null;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody AssignDetail u) {
//		boolean flag = service.update(u);
//		Map<String, Object> data = new HashMap<String, Object>();
//		if (flag) {
//			data.put("data", service.findById(u.getId()));
//		}
//		return new Result(flag, data);
		return null;
	}

}
