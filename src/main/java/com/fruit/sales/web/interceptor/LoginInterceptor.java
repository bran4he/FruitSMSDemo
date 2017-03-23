package com.fruit.sales.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fruit.sales.common.LoginUtil;


public class LoginInterceptor implements HandlerInterceptor {


	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		String url = request.getRequestURI();
		
		logger.info("LoginInterceptor request URI: {}", url);
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute(LoginUtil.USER_SESSION);
		
		logger.info("LoginInterceptor session:{}", username);
		//for dev mode
		return true;
		
//		if(StringUtils.isNotEmpty(username)){
//			return true;
//		}
//		response.sendRedirect(request.getContextPath() + "/login/index");
//		return false;
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
