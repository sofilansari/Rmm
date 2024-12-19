package com.ids.argus.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String useName;
	private String emailId;
	private String password;
	private String resetPaaword;
	
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	  private Set<Roles> roles;
	
	 
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String useName, String emailId, String password, String resetPaaword) {
		super();
		this.id = id;
		this.useName = useName;
		this.emailId = emailId;
		this.password = password;
		this.resetPaaword = resetPaaword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
