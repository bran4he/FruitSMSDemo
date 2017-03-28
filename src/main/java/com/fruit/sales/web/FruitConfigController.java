package com.fruit.sales.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.entity.User;
import com.fruit.sales.service.FruitConfigService;

@RequestMapping("/fruitConfig")
@Controller
public class FruitConfigController implements BaseController<FruitConfig> {

	@Autowired
	private FruitConfigService service;
	
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
