package com.ids.argus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String useName;
	private String emailId;
	private String password;
	private String resetPaaword;
	
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
