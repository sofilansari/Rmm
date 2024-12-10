package com.ids.argus.dto;

public class UserDto {
	
	private String userName;
    private String emailId;
    
	public UserDto(String userName, String emailId) {
		
		this.userName = userName;
		this.emailId = emailId;
	}

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
    
    

}
