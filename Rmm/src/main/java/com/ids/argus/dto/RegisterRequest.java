package com.ids.argus.dto;

import java.util.Set;

public class RegisterRequest {
	
	private String useName;
	private String emailId;
	private String password;
	private String resetPaaword;
	
	
	private Set<RolesDto>roles;


	public String getUseName() {
		return useName;
	}


	public void setUseName(String useName) {
		this.useName = useName;
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


	public String getResetPaaword() {
		return resetPaaword;
	}


	public void setResetPaaword(String resetPaaword) {
		this.resetPaaword = resetPaaword;
	}


	public Set<RolesDto> getRoles() {
		return roles;
	}


	public void setRoles(Set<RolesDto> roles) {
		this.roles = roles;
	}
	
	

}
