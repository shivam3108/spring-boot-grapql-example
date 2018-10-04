package com.graphql.springbootgrapql.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthorizationInterceptor implements HandlerInterceptor {
	static Logger logger = Logger.getLogger(AuthorizationInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		logger.debug("Inside interceptor calss ");
		if(null != request.getHeader("authentication") && "basic".equalsIgnoreCase(request.getHeader("authentication"))) {
			return true;
		}else {
			logger.debug("No authentication ");
			return false;
		}	
	}
}