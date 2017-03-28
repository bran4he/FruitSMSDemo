package com.fruit.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.service.FruitConfigService;

@RequestMapping("/fruitConfig")
@Controller
public class FruitConfigController {

	@Autowired
	private FruitConfigService fruitConfigService;
	
	//规定命名，每个模块的首页
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "fruitConfig";
	}
	
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<FruitConfig> loadAll(){
		return fruitConfigService.listAll();
	}
	
	
}
