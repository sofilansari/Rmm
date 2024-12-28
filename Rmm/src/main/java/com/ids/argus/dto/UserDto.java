package com.ids.argus.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.ids.argus.model.User;

public class UserDto {
		
		private Long id;
	    private String userName;
	    private String password;
	    private String emailId;
	    private String resetPassword;
	    private Set<RolesDto> roles;

	    // Mapping User entity to UserDto
	    public UserDto toDo(User user) {
	    	
	        UserDto dto = new UserDto();
	        dto.setId(user.getId());
	        dto.setPassword(user.getPassword());
	        dto.setEmailId(user.getEmailId());
	        dto.setUserName(user.getUserName());
	        dto.setResetPassword(user.getResetPassword());

	        if (user.getRoles() != null) {
	            Set<RolesDto> rolesDtos = user.getRoles().stream()
	                    .map(role -> new RolesDto().toDo(role))
	                    .collect(Collectors.toSet());
	            dto.setRoles(rolesDtos);
	        }

	        return dto;
	    }

		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserDto(Long id, String userName, String password, String emailId, String resetPassword,
				Set<RolesDto> roles) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.emailId = emailId;
			this.resetPassword = resetPassword;
			this.roles = roles;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
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

		public String getResetPassword() {
			return resetPassword;
		}

		public void setResetPassword(String resetPassword) {
			this.resetPassword = resetPassword;
		}

		public Set<RolesDto> getRoles() {
			return roles;
		}

		public void setRoles(Set<RolesDto> roles) {
			this.roles = roles;
		}

	    
}
