package com.example.saein.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author saein
 * @Date   2019. 2. 15.
 * https://lenditkr.github.io/spring/monitor-batch-jobs-using-aop/
 * https://www.baeldung.com/spring-aop-advice-tutorial
 * https://blog.hanumoka.net/2018/08/24/spring-20180824-spring4-aop-logging/
 * 
 */
@Component
@Aspect
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	//
	@Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled)")
	public void isScheduled() {}

	@Around("isScheduled()")
	public Object profile(ProceedingJoinPoint point) throws Throwable {

		logger.info("----------------- start ----------------------");
		logger.info("Class" + point.getClass());
		logger.info("parameters: " + Arrays.toString(point.getArgs()));
		logger.info("Advice Type: " + point.getKind());
		logger.info("Target instance: " + point.getSignature().getName());
		logger.info("Advice ing.. :" + point.getThis().toString());
		
		try {
			Object result = point.proceed();
			
			logger.info("result : OK!");
			logger.info("----------------- end ----------------------");
			
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	//public void 
	
}
