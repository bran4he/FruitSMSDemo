package com.fruit.sales.web.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruit.sales.common.BusinessConstant;
import com.fruit.sales.entity.Assign;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.weechat.RestultCode;
import com.fruit.sales.weechat.ReturnResult;

@Service
public class CusUserService {

	@Autowired
	private AssignService assignService;
	
	@Transactional
	public ReturnResult registerUser(Assign assign, String weecharOpenid) throws JsonProcessingException{
		
		ReturnResult rr = new ReturnResult();
		assign.setWeecharOpenid(weecharOpenid);
		assignService.update(assign);
		
		rr.setCode(RestultCode.SUCCESS.toString());
		rr.setValue(BusinessConstant.PROCESS_SUCCESS);
		ObjectMapper mapper = new ObjectMapper();  
        String orderJson =  mapper.writeValueAsString(assign);
		rr.setMsg(orderJson);
		
		return rr;
	}
}
