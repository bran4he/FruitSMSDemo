package com.fruit.sales.web.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.dto.UserOrder;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.OrderAddress;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.service.OrderAddressService;
import com.fruit.sales.web.integration.common.UserOrderConstant;
import com.fruit.sales.web.integration.service.IUserOrderService;
import com.fruit.sales.wechat.RestultCode;
import com.fruit.sales.wechat.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/order")
public class IOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(IOrderController.class);
	
	@Autowired
	private IUserOrderService iUserOrderService;

	@Autowired
	private AssignService assinService;


	@Autowired
	private OrderAddressService orderAddressService;
	
	
	@RequestMapping(value="cancleOrder/{orderId}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult cancleOrder(@PathVariable String orderId) throws JsonProcessingException{
		
		logger.info("cancleOrder, wechatId:{} and orderId:{}", orderId);
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(orderId)){
			rr = iUserOrderService.cancleUserOrder(orderId);
			
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		
		return rr;
	}
	
	
	@RequestMapping(value="query/{wechatId}/{status}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult queryOrder(@PathVariable String wechatId, @PathVariable String status) throws JsonProcessingException{
		logger.info("queryOrder, wechatId:{} and status:{}", wechatId, status);
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(wechatId) && StringUtils.isNotEmpty(status)){
			
			rr = iUserOrderService.queryUserOrder(wechatId, status);
			
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		
		return rr;
		
	}
	
	@RequestMapping(value="queryAddress/{wechatId}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult queryOrderAddress(@PathVariable String wechatId) throws JsonProcessingException{
		logger.info("queryOrderAddress, wechatId:{}", wechatId);
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(wechatId)){
			rr = iUserOrderService.queryUserAddress(wechatId);
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		
		return rr;
	}
	
	@RequestMapping(value="delAddress/{addressId}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult deleteOrderAddress(@PathVariable String addressId) throws JsonProcessingException{
		logger.info("deleteOrderAddress, addressId:{}", addressId);
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(addressId)){
			rr = iUserOrderService.deleteUserAddress(addressId);
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		
		return rr;
	}

	@RequestMapping(value="defaultAddr/{wechatId}/{addrId}", method = RequestMethod.GET)
	public @ResponseBody ReturnResult ConfigDefaultAddr(@PathVariable String wechatId, @PathVariable String addrId) {
		ReturnResult rr = new ReturnResult();

		OrderAddress orderAddr = orderAddressService.findById(addrId);
		Assert.notNull(orderAddr, "cannot find this address by id:" + addrId);

		orderAddressService.setDefaultAddr(wechatId, addrId);

		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		rr.setMsg(null);
		return rr;
	}
	
	
	@RequestMapping(value="userOrder/{wechatId}", method = RequestMethod.POST)
	public @ResponseBody ReturnResult userOrder(@RequestBody UserOrder userOrder, @PathVariable String wechatId) throws JsonProcessingException{
		logger.info("user order, get wechatId:{}, and order:\n{}", wechatId, userOrder);
		
		ReturnResult rr = new ReturnResult();
		
		if(StringUtils.isNotEmpty(wechatId)){
			Assign assign = assinService.findByWechatId(wechatId);
			
			if(null != assign){
				
				//用户是否激活
				if(assign.getIsActive().equals(BusinessConstant.NOT_ACTIVE)){
					rr.setCode(RestultCode.EXCEPTION.toString());
					rr.setValue(UserOrderConstant.USER_NOT_ACTIVE);
				}else{
					rr = iUserOrderService.order(assign, userOrder);
				}
				
			}else{
				//用户验证未通过
				rr.setCode(RestultCode.FAIL.toString());
				rr.setValue(UserOrderConstant.USER_NOT_EXIST);
			}
			
		}else{
			rr.setCode(RestultCode.FAIL.toString());
			rr.setValue(BusinessConstant.PARAM_NOT_CORRECT);
		}
		
		return rr;
	}
}
