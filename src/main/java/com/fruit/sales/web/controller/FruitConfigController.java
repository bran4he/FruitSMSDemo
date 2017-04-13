package com.fruit.sales.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.common.Result;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.dao.base.QueryUtil;
import com.fruit.sales.entity.FruitConfig;
import com.fruit.sales.service.FruitConfigService;
import com.fruit.sales.serviceImpl.OrderDetailServiceImpl;
import com.fruit.sales.serviceImpl.OrderServiceImpl;
import com.fruit.sales.web.base.BaseController;

@RequestMapping("/fruitConfig")
@Controller
public class FruitConfigController implements BaseController<FruitConfig> {

	private static final Logger logger = LoggerFactory.getLogger(FruitConfigController.class);
	
	@Autowired
	private FruitConfigService service;
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@Autowired
	private OrderDetailServiceImpl orderDetailService;
	
	//规定命名，每个模块的首页
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "fruitConfig";
	}
	
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<FruitConfig> loadAll(){
		return service.listAll();
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<FruitConfig> list(HttpServletRequest request){
		
		QueryParam queryParam = QueryUtil.getQueryParam(request);
		
		return service.list(queryParam);
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody FruitConfig fruitConfig){
		
		logger.info("add new fruit config: \n{}", fruitConfig);
		
		FruitConfig fruitConfigNew = service.add(fruitConfig);
		Map<String, Object> data = new HashMap<String, Object>();
		if(fruitConfigNew != null){
			data.put("data", fruitConfigNew);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody FruitConfig fruitConfig){
		
		logger.info("update fruitConfig:\n{}", fruitConfig);
		
		//检查更新的最大可定数量不能小于已产生订单的最大订单量
		int maxOrderUnit = orderDetailService.findMaxOrderUnitByFruitId(fruitConfig.getId());
		logger.info("update and get maxOrderUnit from orders:{}", maxOrderUnit);
		
		if(maxOrderUnit > fruitConfig.getMaxOrderNum()){
			Result rr = new Result();
			rr.setResult(false);
			rr.setCode("最大可定数量小于已存在的订单");
			return rr;
		}
		
		boolean flag = service.update(fruitConfig);
		
		Map<String, Object> data = new HashMap<String, Object>();
		if(flag){
			data.put("data", service.findById(fruitConfig.getId()));
		}
		return new Result(flag, data);
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id){
		FruitConfig fruitConfig = service.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = service.delete(fruitConfig);
		if(flag){
			data.put("data", fruitConfig);
		}
		return new Result(flag, data);
	}
	
}
