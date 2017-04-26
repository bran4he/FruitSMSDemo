package com.fruit.sales.web.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.service.FruitConfigService;
import com.fruit.sales.wechat.RestultCode;
import com.fruit.sales.wechat.ReturnResult;

//@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/fruit")
public class IFruitController {

	@Autowired
	private FruitConfigService service;
	
	@RequestMapping(value = "listFruit", method = RequestMethod.GET)
	public @ResponseBody ReturnResult listCurrentMonthFruit() throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();
		
		List<FruitConfig> lst = service.listCurrentMonthFruit();
		
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		
		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(lst);
		rr.setMsg(orderJson);
		
		return rr;
	}
}
