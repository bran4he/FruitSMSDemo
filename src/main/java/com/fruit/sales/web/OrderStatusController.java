package com.fruit.sales.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result addOrderStatus(@RequestBody OrderStatus os){
		OrderStatus osNew = orderStatusService.add(os);
		Map<String, Object> data = new HashMap<String, Object>();
		if(osNew != null){
			data.put("data", osNew);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delOrderStatus(@PathVariable String id){
		OrderStatus os = orderStatusService.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = orderStatusService.delete(os);
		if(flag){
			data.put("data", os);
			return new Result(true, data);
		}else{
			return new Result(false, data);
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
