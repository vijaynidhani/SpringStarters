package com.nidhani.aspects;

import javax.persistence.JoinTable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspects {
	
	Logger log=LoggerFactory.getLogger(ControllerAspects.class);
	
	
	@Before("execution(* com.nidhani..*.*(..))") 
    public void before(JoinPoint joinPoint) {
		 log.info("Before method Execution ........."+joinPoint);
		 
    } 	
}

