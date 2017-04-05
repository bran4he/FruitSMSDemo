package com.fruit.sales.web.integration.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.Order;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.web.integration.common.UserOrderConstant;
import com.fruit.sales.web.integration.service.IUserOrderService;
import com.fruit.sales.web.integration.service.IUserService;
import com.fruit.sales.weechat.RestultCode;
import com.fruit.sales.weechat.ReturnResult;

@Controller
@RequestMapping("/rest/order")
public class IOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(IOrderController.class);
	
	@Autowired
	private IUserOrderService iUserOrderService;

	@Autowired
	private AssignService assinService;
	
	@Autowired
	private IUserService iUserService;
	
	
	@RequestMapping(value="query/{weechatId}/{status}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult queryOrder(@PathVariable String weechatId, @PathVariable String status) throws JsonProcessingException{
		logger.info("queryOrder, weechatId:{} and status:{}", weechatId, status);
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(weechatId) && StringUtils.isNotEmpty(status)){
			
			rr = iUserOrderService.queryUserOrder(weechatId, status);
			
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		
		return rr;
		
	}
	
	
	
	@RequestMapping(value="userOrder/{weechatId}", method = RequestMethod.POST)
	public @ResponseBody ReturnResult userOrder(@RequestBody Order order, @PathVariable String weechatId) throws JsonProcessingException{
		logger.info("user order, get weechatId:{}, and order:\n{}", weechatId, order);
		
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(weechatId)){
			Assign assign = assinService.findByWeechatId(weechatId);
			
			if(null != assign){
				rr = iUserOrderService.order(assign, order);
			}else{
				//用户验证未通过
				rr.setCode(RestultCode.FAIL.toString());
				rr.setValue(UserOrderConstant.USER_NOT_AUTH);
			}
			
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		
		return rr;
	}
}
