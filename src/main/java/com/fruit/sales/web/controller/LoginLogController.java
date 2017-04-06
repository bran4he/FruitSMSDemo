package com.fruit.sales.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.dao.base.QueryParam;
import com.fruit.sales.dao.base.QueryResult;
import com.fruit.sales.dao.base.QueryUtil;
import com.fruit.sales.service.LoginLogService;
import com.fruit.sales.vo.LoginLogVO;

@RequestMapping("/loginLog")
@Controller
public class LoginLogController {

	private static final Logger logger = LoggerFactory.getLogger(LoginLogController.class);
	
	@Autowired
	private LoginLogService service;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "loginLog";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody QueryResult<LoginLogVO> list(HttpServletRequest request){
		QueryParam queryParam = QueryUtil.getQueryParam(request);
		
		return service.listVO(queryParam);
	}
	
	//only need load all records, no need to add/update/delete
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<LoginLogVO> loadAllVO(){
		return service.listAllVO();
	}
}
