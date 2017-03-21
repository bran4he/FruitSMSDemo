package com.fruit.sales.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.common.Result;
import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.serviceImpl.OrderStatusServiceImpl;
import com.fruit.sales.web.demo.PersonController;

@RequestMapping("/os")
@Controller
public class OrderStatusController {

	private static final Logger logger = LoggerFactory.getLogger(OrderStatusController.class);
	
	@Autowired
	private OrderStatusServiceImpl orderStatusService;
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<OrderStatus> loadAllOrderStatus(){
		return orderStatusService.listAll();
	}
	
	@RequestMapping(value="/add/{name}", method = RequestMethod.GET)
	public @ResponseBody Result addOrderStatus(@PathVariable String name){
		OrderStatus os = new OrderStatus();
		os.setName(name);
		boolean flag = orderStatusService.add(os);
		if(flag){
			return new Result(true, "add success");
		}else{
			return new Result(false, "add fail");
		}
	}
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		logger.info("goto os index");
		return "order_status";
	}
	
	//test
	@RequestMapping(value = "data.json", method = RequestMethod.GET)
	public @ResponseBody Object getJson() throws IOException{
		
		String file = PersonController.class.getResource("/os.json").getFile();
		
		BufferedReader br = new BufferedReader(new FileReader(file)) ;
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		return sb.toString();
	}
}
