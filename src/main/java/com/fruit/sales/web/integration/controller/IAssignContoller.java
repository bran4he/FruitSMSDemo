package com.fruit.sales.web.integration.controller;

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
import com.fruit.sales.weechat.RegisterStatus;
import com.fruit.sales.weechat.RestultCode;
import com.fruit.sales.weechat.ReturnResult;

@Controller
@RequestMapping("/rest/assign")
public class IAssignContoller {

	private static final Logger logger = LoggerFactory.getLogger(IOrderController.class);
	
	@Autowired
	private AssignService assinService;
	
	@RequestMapping(value="checkBalance/{weechatId}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult checkAssignBalance(@PathVariable String weechatId) throws JsonProcessingException{
		
		logger.info("checkAssignBalance, weechatId:{}", weechatId);
		
		Assign assign = assinService.findByWeechatId(weechatId);
		
		ReturnResult rr = new ReturnResult();
		
		rr.setCode(RestultCode.SUCCESS.name());
		rr.setValue(String.valueOf(assign.getBalanceUnit()));
		
		return rr;
		
	}
}
