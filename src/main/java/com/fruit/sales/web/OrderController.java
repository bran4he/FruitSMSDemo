package com.fruit.sales.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruit.sales.common.Result;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.entity.Order;
import com.fruit.sales.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController implements BaseController<Order>{
	
	@Autowired
	private OrderService service;

	@Override
	public String index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<Order> list(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result del(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
