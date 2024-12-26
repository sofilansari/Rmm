package com.ids.argus.dto;

import java.util.Set;

<<<<<<< HEAD
import com.ids.argus.model.Roles;

=======
>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44
public class RegisterRequest {
	
	private String userName;
	private String emailId;
	private String password;
	private String resetPassword;
	
	private Set<Roles>roles;
	
	
<<<<<<< HEAD
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
=======
	private Set<RolesDto>roles;


	public String getUseName() {
		return useName;
	}


	public void setUseName(String useName) {
		this.useName = useName;
>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44
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
<<<<<<< HEAD
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
=======


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
	
>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44
	

}
