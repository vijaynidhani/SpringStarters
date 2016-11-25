
package com.nidhani;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
  public AppConfig() {
	System.out.println("AppConfig initiated ...........");  
  } 
}