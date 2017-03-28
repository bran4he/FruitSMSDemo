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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.common.LoginUtil;
import com.fruit.sales.common.Result;
import com.fruit.sales.entity.OrderStatus;
import com.fruit.sales.entity.User;
import com.fruit.sales.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	//规定命名，每个模块的首页
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "user";
	}
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<User> loadAll(){
		return userService.listAll();
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public @ResponseBody Result add(@RequestBody User u){
		User uNew = userService.add(u);
		Map<String, Object> data = new HashMap<String, Object>();
		if(uNew != null){
			data.put("data", uNew);
			return new Result(true, data);
		}else{
			return new Result(false, data);
		}
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result del(@PathVariable String id){
		User u = userService.findById(id);
		Map<String, Object> data = new HashMap<String, Object>();
		boolean flag = userService.delete(u);
		if(flag){
			data.put("data", u);
			return new Result(true, data);
		}
		return new Result(flag, data);
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public @ResponseBody Result update(@RequestBody User u){
		boolean flag = userService.update(u);
		Map<String, Object> data = new HashMap<String, Object>();
		if(flag){
			data.put("data", userService.findById(u.getId()));
		}
		return new Result(flag, data);
	}
	
	
	
}
