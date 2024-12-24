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

	public User(Long id, String userName, String emailId, String password, String resetPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.resetPassword = resetPassword;
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
	
	
	
}
