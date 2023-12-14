package com.hari.webservice.restapi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class Performance {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Around("com.hari.webservice.restapi.aop.BasicConfigAOP.performanceTimer()")
	public Object logMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object resultValue = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		logger.info("\n\n\nMethod Performance : \n {} has called and \n time taken {}",proceedingJoinPoint,end-start);
		
		return resultValue;
	}
	
	
	
	
}
