package com.graphql.springbootgrapql.security;

import java.util.LinkedHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.graphql.springbootgrapql.exception.NoAuthenticationException;

@Aspect
@Configuration
public class AopAuthorization {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Before(value = "execution(* com.graphql.springbootgrapql.resource.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("before execution of {}", joinPoint);
		Object[] arguments = joinPoint.getArgs();
		   for (Object argument: arguments) {
			   logger.info("Arguments : "+ argument);
			   
			   if(argument instanceof  LinkedHashMap) {
				LinkedHashMap map = (LinkedHashMap) argument;
				   if(null != map.get("authentication") && "basic".equalsIgnoreCase((String) map.get("authentication"))) {
					   logger.info("Authentication Done");
				   } else {
					   logger.info("No Authentication found ");
					   throw new NoAuthenticationException();
				   }
			   }
		   }
	}

}
