package com.cognizant.banking.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
	// Performance monitoring advice can be added here
	Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);
	@Around("execution(* com.cognizant.banking.models.*.*(..))")
	public void monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		// Implementation for performance monitoring
		long startTime=System.nanoTime();
		Object result=joinPoint.proceed();
		long endTime=System.nanoTime();
		long duration=endTime-startTime/1000000;
		logger.info("Method "+joinPoint.getSignature().getName()+" executed in "+duration+" ms");
	}
}
