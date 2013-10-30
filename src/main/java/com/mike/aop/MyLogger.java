package com.mike.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MyLogger {

    private Logger log = LoggerFactory.getLogger(MyLogger.class);

    @Around("execution(* com.mike.mvc.HomeController.*(..))")
    public String log(ProceedingJoinPoint  point) throws Throwable {
  
    	StringBuffer logMsg = new StringBuffer();
    	String className = point.getTarget().getClass().getCanonicalName();
    	String methodName = point.getSignature().getName();
    	
    	logMsg.append(className);
    	logMsg.append('.');
    	logMsg.append(methodName);
    	logMsg.append('(');
    	
		// append args
		Object[] args = point.getArgs();
		for (int i = 0; i < args.length; i++) {
			logMsg.append(args[i]).append(", ");
		}
		if (args.length > 0) {
			logMsg.deleteCharAt(logMsg.length() - 1); //space
			logMsg.deleteCharAt(logMsg.length() - 1); //comma
		}
    	logMsg.append(")");

    	
    	//String signature = className + "." + methodName + "()";
    	
    	log.debug("ENTERING: " + logMsg);
    	String  result = (String) point.proceed();
    	log.debug("LEAVING: " + logMsg + ':' + result);
    	return result;
    }
}
