package com.fruit.sales.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.common.Result;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.OrderDetail;
import com.fruit.sales.service.OrderDetailService;
import com.fruit.sales.web.base.BaseController;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController implements BaseController<OrderDetail>{

	@Autowired
	private OrderDetailService service;
	
	@RequestMapping(value="detail/{orderId}", method = RequestMethod.GET)
	public @ResponseBody Result listOrderDetailByOrderId(@PathVariable String orderId){
		
		List<OrderDetail> lst = service.findByOrderId(orderId);
		Map<String, Object> data = new HashMap<String, Object>();
		
		if(null != lst){
			data.put("data", lst);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
		
	}
	
	@Override
	public String index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<OrderDetail> list(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(OrderDetail obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(OrderDetail obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result del(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
