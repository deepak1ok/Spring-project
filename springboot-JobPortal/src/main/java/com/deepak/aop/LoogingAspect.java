package com.deepak.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoogingAspect {

	public static final Logger logger = LoggerFactory.getLogger(LoogingAspect.class);

	// return_type, class_name(like., com.deepak.aop).method_name(argument)

	@Before("execution(*,com.deepak.services.JobService.*(..))")
	public void logMethodCall() {
		logger.info("Method Called..");
	}

}
