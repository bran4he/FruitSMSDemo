package com.fruit.sales.web.integration;

import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.common.OrderConstant;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.entity.Order;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.service.FruitConfigService;
import com.fruit.sales.service.OrderService;
import com.fruit.sales.weechat.RestultCode;
import com.fruit.sales.weechat.ReturnResult;

@Service
public class UserOrderService {

	private static final Logger logger = LoggerFactory.getLogger(UserOrderService.class);
	
	@Autowired
	private OrderService service;

	@Autowired
	private AssignService assinService;
	
	@Autowired
	private FruitConfigService fruitConfigService;
	
	@Transactional
	public ReturnResult order(Assign assign, Order order) throws JsonProcessingException{

		ReturnResult rr = new ReturnResult();
		
		FruitConfig fruitConfig = fruitConfigService.findById(order.getFruitId());
		int balanceUnitFromFruit = fruitConfig.getBalanceNum();
		
		int balanceUnitFromAssign = assign.getBalanceUnit();
		
		
		//check the order date
		if(fruitConfig.getMaxOrderDay().compareTo(new Date()) < 0){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(BusinessConstant.EXCEED_MAX_ORDER_DATE);
			return rr;
		}
		
		//检查水果设置参数 max provide num - balance num
		if(fruitConfig.getBalanceNum() < order.getOrderUnit()){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(BusinessConstant.EXCEED_FRUIT_BALANCE);
			return rr;
		}
		
		
		//检查水果设置参数max order num
		if(fruitConfig.getMaxOrderNum() < order.getOrderUnit()){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(BusinessConstant.EXCEED_MAX_ORDER_LIMIT);
			return rr;
		}
		
		//检查用户的库存
		if(assign.getBalanceUnit() < order.getOrderUnit()){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(BusinessConstant.BALANCE_NOT_ENOUGH);
			return rr;
		}
		
		//check assign balance unit
		if(balanceUnitFromAssign < order.getOrderUnit()){
			rr.setCode(RestultCode.EXCEPTION.toString());
			rr.setValue(BusinessConstant.EXCEED_ASSIGN_BALANCE_UNIT);
			return rr;
		}
		
		//update assign
		assign.setBalanceUnit(balanceUnitFromAssign - order.getOrderUnit());
		assinService.update(assign);
		
		//update fruitConfig
		fruitConfig.setBalanceNum(balanceUnitFromFruit - order.getOrderUnit());
		fruitConfigService.update(fruitConfig);
		
		//save order
		order.setAssignId(assign.getId());
		order.setStatusId(OrderConstant.WAIT_FOR);
		order.setPlanDeliveryDate(new DateTime().plusDays(7).toDate());
		
		setDefaultOrderParams(order);
		
		logger.info("order before save: \n{}", order);
		
		service.add(order);
		
		//retrun message
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.USER_ORDER_SUCCESS);
		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(order);
		rr.setMsg(orderJson);
		
		return rr;
	
	}
	
	private void setDefaultOrderParams(Order order){
		order.setDeliveryDate(new DateTime().plusDays(7).toDate());
		order.setDeliveryBy("DeliveryBy");
		order.setDeliveryRemark("DeliveryRemark");
		order.setFinishDate(new DateTime().plusDays(7).toDate());
		order.setFinishBy("FinishBy");
		order.setFinishRemark("FinishRemark");
		order.setExtendData("extdata");
	}
	
}
