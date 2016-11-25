package com.nidhani.aspects;

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
    public void before() {
		log.info("Before method Execution .........");
    } 	
}

