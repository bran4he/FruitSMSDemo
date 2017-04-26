package com.fruit.sales.web.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.service.FruitConfigService;
import com.fruit.sales.service.PubConfigService;
import com.fruit.sales.wechat.RestultCode;
import com.fruit.sales.wechat.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/pub")
public class IPubController {

	@Autowired
	private PubConfigService service;
	
	@RequestMapping(value = "maxOrderDay", method = RequestMethod.GET)
	public @ResponseBody ReturnResult getMaxOrderDay() throws JsonProcessingException{
		ReturnResult rr = new ReturnResult();
		PubConfig pubCfg = service.findByName(BusinessConstant.MAX_ORDER_DAY_TO);
		String maxOrderDay = pubCfg.getValue();

		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		rr.setMsg(maxOrderDay);
		
		return rr;
	}
}
