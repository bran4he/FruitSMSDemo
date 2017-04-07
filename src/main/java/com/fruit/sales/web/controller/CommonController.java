package com.fruit.sales.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.entity.CommonEntity;

@Controller
@RequestMapping("/common")
public class CommonController {

	@RequestMapping(value = "virtualList", method = RequestMethod.GET)
	public @ResponseBody List<CommonEntity> virtualList(){
		 List<CommonEntity> data = new  ArrayList<CommonEntity>();
		 
		 CommonEntity comm = new CommonEntity("0", "真实号码");
		 data.add(comm);
		 comm = new CommonEntity("1", "虚拟号码");
		 data.add(comm);
		 
		return data;
	}
	
	@RequestMapping(value = "activeList", method = RequestMethod.GET)
	public @ResponseBody List<CommonEntity> activeList(){
		List<CommonEntity> data = new  ArrayList<CommonEntity>();
		
		CommonEntity comm = new CommonEntity("0", "未激活");
		data.add(comm);
		comm = new CommonEntity("1", "已激活");
		data.add(comm);
		
		return data;
	}
}
