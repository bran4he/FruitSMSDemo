package com.fruit.sales.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.entity.User;
import com.fruit.sales.serviceImpl.OrderStatusServiceImpl;
import com.fruit.sales.web.demo.PersonController;

@RequestMapping("/orderStatus")
@Controller
public class OrderStatusController implements BaseController<OrderStatus>{

	private static final Logger logger = LoggerFactory.getLogger(OrderStatusController.class);
	
	@Autowired
	private OrderStatusServiceImpl service;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		logger.info("goto os index");
		return "orderStatus";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<OrderStatus> list(HttpServletRequest request){
		
		QueryParam queryParam = QueryUtil.getQueryParam(request);
		
		return service.list(queryParam);
	}
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<OrderStatus> loadAll(){
		return service.listAll();
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody OrderStatus os){
		OrderStatus osNew = service.add(os);
		Map<String, Object> data = new HashMap<String, Object>();
		if(osNew != null){
			data.put("data", osNew);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id){
		OrderStatus os = service.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = service.delete(os);
		if(flag){
			data.put("data", os);
		}
		return new Result(flag, data);
	}
	
	
	

	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody OrderStatus os){
		boolean flag = service.update(os);
		Map<String, Object> data = new HashMap<String, Object>();
		if(flag){
			data.put("data", service.findById(os.getId()));
		}
		return new Result(flag, data);
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
