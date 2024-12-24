package com.ids.argus.dto;

import com.ids.argus.model.User;

public class UserDto {
	
	 private String password;
	    private String emailId;
	    
	    // Instance method to convert User entity to UserDto
	    public UserDto toDo(User user) {
	        UserDto dto = new UserDto();
	        dto.setPassword(user.getPassword());
	        dto.setEmailId(user.getEmailId());
	        return dto;
	    }
	    
	    // Constructor for UserDto
	    public UserDto(String password, String emailId) {
	        this.password = password;
	        this.emailId = emailId;
	    }

	    // Default constructor (optional)
	    public UserDto() {
	    }

	    // Getters and setters
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
