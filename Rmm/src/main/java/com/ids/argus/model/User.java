package com.ids.argus.model;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String userName;
    private String emailId;
    private String password;
    private String resetPassword;

	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	  private Set<Roles> roles;
	
	 
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public User(Long id, String userName, String emailId, String password, String resetPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.resetPassword = resetPassword;
	}
=======

>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

<<<<<<< HEAD
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
=======


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
=======


	public String getResetPaaword() {
		return resetPaaword;
	}



	public void setResetPaaword(String resetPaaword) {
		this.resetPaaword = resetPaaword;
>>>>>>> 6a53404616e5da8f0bb6bb61314fe3f121153b44
	}



	public Set<Roles> getRoles() {
		return roles;
	}



	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	
}
