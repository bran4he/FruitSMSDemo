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
import com.fruit.sales.entity.Assign;
import com.fruit.sales.service.AssignService;
import com.fruit.sales.web.base.BaseController;

@RequestMapping("/assign")
@Controller
public class AssignController implements BaseController<Assign> {

	@Autowired
	private AssignService service;
	

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "assign";
	}
	
	@Override
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<Assign> list(HttpServletRequest request) {
		QueryParam queryParam = QueryUtil.getQueryParam(request);
		
		return service.list(queryParam);
	}


	@Override
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody Assign assign){
		Assign assignNew = service.add(assign);
		Map<String, Object> data = new HashMap<String, Object>();
		if(assignNew != null){
			data.put("data", assignNew);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}

	@Override
	@RequestMapping(value="update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody Assign assign){
		boolean flag = service.update(assign);
		Map<String, Object> data = new HashMap<String, Object>();
		if(flag){
			data.put("data", service.findById(assign.getId()));
		}
		return new Result(flag, data);
	}

	@Override
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id){
		Assign assign = service.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = service.delete(assign);
		if(flag){
			data.put("data", assign);
			return new Result(true, data);
		}
		return new Result(flag, data);
	}

}
