package com.assetware.beans;

public class AWUser {

	private String username;
	
	private String userType;
	private Boolean active;
	private String email;
	
	public AWUser(String username) {
		super();
		this.username = username;
	}

	public AWUser(String username, String userType, Boolean active) {
		super();
		this.username = username;
		this.userType = userType;
		this.active = active;
	}
	
	@Override
	public String toString() {
		return username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
