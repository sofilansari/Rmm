package com.ids.argus.dto;

import java.util.Set;

import com.ids.argus.model.Roles;

public class RegisterRequest {
	
	private String userName;
	private String emailId;
	private String password;
	private String resetPassword;
	
	private Set<Roles>roles;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getresetPassword() {
		return resetPassword;
	}
	public void setresetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	

}
