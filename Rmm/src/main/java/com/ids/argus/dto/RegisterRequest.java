package com.ids.argus.dto;

public class RegisterRequest {
	
	private String useName;
	private String emailId;
	private String password;
	private String resetPaaword;
	
	
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
	
	

}
