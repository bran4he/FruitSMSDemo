package com.fruit.sales.web.integration.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.web.integration.common.UserConstant;
import com.fruit.sales.web.integration.service.IUserService;
import com.fruit.sales.weechat.RegisterStatus;
import com.fruit.sales.weechat.RestultCode;
import com.fruit.sales.weechat.ReturnResult;

@Controller
@RequestMapping("/rest/user")
public class IUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(IUserController.class);

	@Autowired
	private AssignService assignService;
	
	@Autowired
	private IUserService IUserService;
	
	@RequestMapping(value="validatePhone/{phone}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult checkPhoneStatus(@PathVariable String phone){
		Assign assign = assignService.findBySlavePhone(phone);
		
		logger.info("validate phone and get assign:\n{}", assign);
		
		ReturnResult rr = new ReturnResult();
		
		if(assign != null){
			if(BusinessConstant.IS_ACTIVE.equals(assign.getIsActive())){
				rr.setValue(RegisterStatus.ACTIVE.toString());
			}else if(BusinessConstant.NOT_ACTIVE.equals(assign.getIsActive())){
				rr.setValue(RegisterStatus.NOTACTIVE.toString());
			}
		}else{
			rr.setValue(RegisterStatus.NA.toString());
		} 
		
		return rr;
	}
	
	@RequestMapping(value="validateWechatId/{wechatId}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult checkWechatIdStatus(@PathVariable String wechatId){
		Assign assign = assignService.findByWechatId(wechatId);
		
		logger.info("validate wechatId and get assign:\n{}", assign);
		
		ReturnResult rr = new ReturnResult();
		
		if(assign != null){
			if(BusinessConstant.IS_ACTIVE.equals(assign.getIsActive())){
				rr.setValue(RegisterStatus.ACTIVE.toString());
			}else if(BusinessConstant.NOT_ACTIVE.equals(assign.getIsActive())){
				rr.setValue(RegisterStatus.NOTACTIVE.toString());
			}
		}else{
			rr.setValue(RegisterStatus.NA.toString());
		} 
		
		return rr;
	}

	@RequestMapping(value="register/{phone}/{wechatOpenId}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult registerUser(@PathVariable String phone, @PathVariable String wechatOpenId) throws JsonProcessingException{
		logger.info("registerUser with phone:{} and wechatOpenId:{}", phone, wechatOpenId);
		
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(phone) && StringUtils.isNotEmpty(wechatOpenId)){
			Assign assign = assignService.findBySlavePhone(phone);
			if(null != assign){
				rr = IUserService.registerUser(assign, wechatOpenId);
			}else{
				//user not exists
				rr.setCode(RestultCode.FAIL.toString());
				rr.setValue(UserConstant.USER_NOT_EXISTS);
			}
			
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		return rr;
	}

}
