package com.hari.webservice.restapi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogginAspect {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("com.hari.webservice.restapi.aop.BasicConfigAOP.controllerAopMethod()")
	public void logMethodCall(JoinPoint joinPoint) {
		logger.info("\n\n\nMethod call Before on Controller \n {} \n\n\n",joinPoint);
	}
	
	@AfterThrowing(
			pointcut = "com.hari.webservice.restapi.aop.BasicConfigAOP.controllerAopMethod()",
			throwing = "exception"
			)
	public void logMethodAfterThrowingCall(JoinPoint joinPoint, Exception exception) {
		logger.info("\n\n\nMethod call After error on Throwing Exception on  Controller \n{} : with ex : {} \n\n\n",joinPoint,exception);
	}
	
	@AfterReturning(
			pointcut = "com.hari.webservice.restapi.aop.BasicConfigAOP.controllerAopMethod()",
			returning = "resultValue"
			)
	public void logMethodAfterReturningCall(JoinPoint joinPoint , Object resultValue) {
		logger.info("\n\n\nMethod call After  on Results on Controller \n {}  : value of {} \n\n\n",joinPoint,resultValue);
	}
	
	
	
}
