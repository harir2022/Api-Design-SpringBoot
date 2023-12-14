package com.hari.webservice.restapi.aop;

import org.aspectj.lang.annotation.Pointcut;

public class BasicConfigAOP {
	
	@Pointcut(value = "execution(* com.hari.webservice.restapi.controller.*.*(..))")
	public void controllerAopMethod() {}
	
	@Pointcut(value = "execution(* com.hari.webservice.restapi.repository.*.*(..))")
	public void dataServiceAopMethod() {}
	
	@Pointcut("@annotation(com.hari.webservice.restapi.aop.customannotations.Timer)")
	public void performanceTimer() {}
	
	
}
