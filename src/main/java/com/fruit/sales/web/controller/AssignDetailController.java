package com.fruit.sales.web.controller;

import java.util.HashMap;
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
import com.fruit.sales.entity.AssignDetail;
import com.fruit.sales.service.AssignDetailService;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.serviceImpl.AssignAndDetailService;
import com.fruit.sales.web.base.BaseController;

@Controller
@RequestMapping("/assignDetail")
public class AssignDetailController implements BaseController<AssignDetail> {

	private static final Logger logger = LoggerFactory.getLogger(AssignDetailController.class);

	@Autowired
	private AssignDetailService service;
	
	@Autowired
	private AssignService assignService; 
	
	@Autowired
	private AssignAndDetailService assignAndDetailService;

	// 规定命名，每个模块的首页
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "assignDetail";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<AssignDetail> list(
			HttpServletRequest request) {

		QueryParam queryParam = QueryUtil.getQueryParam(request);

		return service.list(queryParam);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody AssignDetail ad) {
		
		logger.info("AssignDetail request:\n ?", ad.toString());
		
		AssignDetail adNew = null;
		adNew = assignAndDetailService.handleActiveAdd(ad);
		
		Map<String, Object> data = new HashMap<String, Object>();
		if (adNew != null) {
			data.put("data", adNew);
			return new Result(true, data);
		} else {
			return new Result(false, data);
		}
	}

	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id) {
//		AssignDetail u = service.findById(id);
//		Map<String, Object> data = new HashMap<String, Object>();
//		boolean flag = service.delete(u);
//		if (flag) {
//			data.put("data", u);
//			return new Result(true, data);
//		}
//		return new Result(flag, data);
		return null;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody AssignDetail u) {
//		boolean flag = service.update(u);
//		Map<String, Object> data = new HashMap<String, Object>();
//		if (flag) {
//			data.put("data", service.findById(u.getId()));
//		}
//		return new Result(flag, data);
		return null;
	}

}
