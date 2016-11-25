package com.nidhani.user;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	private List<String> role;

}
