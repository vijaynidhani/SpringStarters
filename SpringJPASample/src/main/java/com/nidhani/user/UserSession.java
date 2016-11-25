package com.nidhani.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS )
public class UserSession {
	
	public static String USER_SESSION="USER_SESSION";
	
	@Autowired
	private User user;
	
   	private Date lastLogin;
   	
   	private Date loginTime;
   	
   	public UserSession() {
	    loginTime=new Date();
	}
   	
   	public void setName(String name) {
   		user.setName(name);
   	}
   	
   	public String getName() {
   		return user.getName();
   	}
  
   	public Date getLoginTime() {
   		return loginTime;
   	}
   	
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return user.toString() +" : "+  getLoginTime();
	}
   	
}
