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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.common.Result;
import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.dao.base.QueryUtil;
import com.fruit.sales.entity.Order;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.service.OrderService;
import com.fruit.sales.web.base.BaseController;

@Controller
@RequestMapping("/order")
public class OrderController implements BaseController<Order>{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService service;

	@Autowired
	private AssignService assinService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "order";
	}
	
	@Override
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<Order> list(HttpServletRequest request) {
		QueryParam queryParam = QueryUtil.getQueryParam(request);
		
		return service.list(queryParam);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<Order> loadAll(){
		return service.listAll();
	}

	@Override
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody Order order){
		Order orderNew = service.add(order);
		Map<String, Object> data = new HashMap<String, Object>();
		if(orderNew != null){
			data.put("data", orderNew);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}


	@Override
	@RequestMapping(value="update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody Order order){
		boolean flag = service.update(order);
		Map<String, Object> data = new HashMap<String, Object>();
		if(flag){
			data.put("data", service.findById(order.getId()));
		}
		return new Result(flag, data);
	}

	@Override
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id){
		Order order = service.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = service.delete(order);
		if(flag){
			data.put("data", order);
			return new Result(true, data);
		}
		return new Result(flag, data);
	}
	
	@RequestMapping(value="mutiUpdate", method = RequestMethod.POST)
	public @ResponseBody Result mutiUpdateStatus(@RequestParam("ids") String ids, @RequestParam("status") String status){
	
		logger.info("mutiUpdate, ids:{} and status:{}", ids, status);
		
		String[] idArr = ids.split(",");
		int count = service.updateMutiStatus(idArr, status);
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("updateCount", count);
		data.put("requestCount", idArr.length);
		
		if(count == idArr.length){
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}

}
