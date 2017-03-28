package com.fruit.sales.web;

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
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.serviceImpl.PubConfigServiceImpl;

@RequestMapping("/pubConfig")
@Controller
public class PubConfigController implements BaseController<PubConfig>{

	private static final Logger logger = LoggerFactory.getLogger(PubConfigController.class);

	@Autowired
	private PubConfigServiceImpl service;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		logger.info("goto os pubConfig");
		return "pubConfig";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<PubConfig> list(HttpServletRequest request){
		
		QueryParam queryParam = QueryUtil.getQueryParam(request);
		
		return service.list(queryParam);
	}
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<PubConfig> loadAll(){
		return service.listAll();
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody PubConfig pubCfg){
		PubConfig pubCfgNew = service.add(pubCfg);
		Map<String, Object> data = new HashMap<String, Object>();
		if(pubCfgNew != null){
			data.put("data", pubCfgNew);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody PubConfig pubCfg){
		boolean flag = service.update(pubCfg);
		Map<String, Object> data = new HashMap<String, Object>();
		if(flag){
			data.put("data", service.findById(pubCfg.getId()));
		}
		return new Result(flag, data);
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id){
		PubConfig pubCfg = service.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = service.delete(pubCfg);
		if(flag){
			data.put("data", pubCfg);
		}
		return new Result(flag, data);
	}
}
