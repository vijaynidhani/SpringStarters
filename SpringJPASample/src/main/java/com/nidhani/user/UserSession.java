package com.nidhani.user;

import java.util.Date;

public class UserSession {
	
	public static String USER_SESSION="USER_SESSION";
	
   	private Date lastLogin;

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
   	
}
