package com.cognizant.banking.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountLoggingAspect {
	
	Logger logger = LoggerFactory.getLogger(AccountLoggingAspect.class);
	@Before("execution(* com.cognizant.banking.models.*.*(..))")
	public void logBeforeAccountMethods(JoinPoint joinPoint) throws Throwable {
		logger.info("AccountLoggingAspect: Before logAccountMethod");
		String methodName = joinPoint.getSignature().getName();
		logger.info("Entering method: " + methodName);
		
	}
	@Around("execution(* com.cognizant.banking.models.*.*(..))")
	public Object logAroundAccountMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("AccountLoggingAspect: logAccountMethod");
		String methodName = joinPoint.getSignature().getName();
		logger.info("Entering method: " + methodName);
		Object result = joinPoint.proceed();
		logger.info("Exiting method: " + methodName);
		return result;
	}
	
	@After("execution(* com.cognizant.banking.models.*.*(..))")
	public void logAfterAccountMethods(JoinPoint joinPoint) throws Throwable {
		logger.info("AccountLoggingAspect: After logAccountMethod");
		String methodName = joinPoint.getSignature().getName();
		logger.info("Entering method: " + methodName);
		
	}

}
