package com.fruit.sales.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.sales.entity.Assign;
import com.fruit.sales.service.AssignService;


public class IntegrationAuthInterceptor implements HandlerInterceptor {

	
	private static final Logger logger = LoggerFactory.getLogger(IntegrationAuthInterceptor.class);
	
	@Autowired
	private AssignService assinService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		String url = request.getRequestURI();
		String auth =  request.getHeader("Auth");
		logger.info("IntegrationAuthInterceptor request URI: {} with Auth:{} in header", url, auth);
		
		Assign assign = assinService.findByWechatId(auth);
		if(null != assign){
			return true;
		}else{
			response.getWriter().write("client unauthorized!");
			return false;
		}
		
		//for dev mode
//		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
