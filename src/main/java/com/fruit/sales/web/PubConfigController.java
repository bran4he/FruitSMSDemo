package com.fruit.sales.web;

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
import com.fruit.sales.entity.PubConfig;
import com.fruit.sales.serviceImpl.PubConfigServiceImpl;

@RequestMapping("/pubConfig")
@Controller
public class PubConfigController {

	private static final Logger logger = LoggerFactory.getLogger(PubConfigController.class);

	@Autowired
	private PubConfigServiceImpl pubConfigService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		logger.info("goto os pubConfig");
		return "pubConfig";
	}
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<PubConfig> loadAll(){
		return pubConfigService.listAll();
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody PubConfig pubCfg){
		PubConfig pubCfgNew = pubConfigService.add(pubCfg);
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
		boolean flag = pubConfigService.update(pubCfg);
		Map<String, Object> data = new HashMap<String, Object>();
		if(flag){
			data.put("data", pubConfigService.findById(pubCfg.getId()));
		}
		return new Result(flag, data);
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id){
		PubConfig pubCfg = pubConfigService.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = pubConfigService.delete(pubCfg);
		if(flag){
			data.put("data", pubCfg);
		}
		return new Result(flag, data);
	}
}
