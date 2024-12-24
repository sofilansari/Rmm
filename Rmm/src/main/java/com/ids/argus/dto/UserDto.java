package com.ids.argus.dto;

public class UserDto {
	
	private String password;
    private String emailId;
    
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String password, String emailId) {
		super();
		this.password = password;
		this.emailId = emailId;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
    
    
}
