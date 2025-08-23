package com.deepak.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//	return_type class_name(like., com.deepak.aop).method_name(argument)
//  execution(*,com.deepak.services.JobService.*(..)) --> this is point cut
//	@Before --> this is advice

	@Before("execution(* com.deepak.services.JobService.*(..)) ")
	public void logMethodCall(JoinPoint jp) {
		LOGGER.info("Method Called.. " + jp.getSignature().getName());
	}

//	@Before("execution(* com.deepak.services.JobService.getJob(..)) || execution(* com.deepak.services.JobService.updateJob(..))")
//	public void logMethodCall(JoinPoint jp) {
//		LOGGER.info("Method Called.. " + jp.getSignature().getName());
//	}

	@After("execution(* com.deepak.services.JobService.*(..))")
	public void logMethodExecuted(JoinPoint jp) {
		LOGGER.info("Method Executed.. " + jp.getSignature().getName());
	}

	@AfterThrowing("execution(* com.deepak.services.JobService.*(..))")
	public void logMethodCrashed(JoinPoint jp) {
		LOGGER.info("Method has some issues " + jp.getSignature().getName());
	}

	@AfterReturning("execution(* com.deepak.services.JobService.*(..)) ")
	public void logMethodExecutedSuccess(JoinPoint jp) {
		LOGGER.info("Method Executed Successfully " + jp.getSignature().getName());
	}

}
