package com.ids.argus.dto;

import com.ids.argus.model.User;

public class UserDto {
	
<<<<<<< HEAD
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
=======
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
>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44

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

<<<<<<< HEAD
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
    
    
=======
	    public String getEmailId() {
	        return emailId;
	    }

	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }    

>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44
}
