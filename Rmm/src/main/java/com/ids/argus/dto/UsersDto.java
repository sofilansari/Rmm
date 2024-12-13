package com.ids.argus.dto;

import com.ids.argus.model.Users;

public class UsersDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String confirmPassword;
	private String contact;
	private String address;
	private int states;
	private boolean isDelete;
	
	public UsersDto toDo(Users users) {
		
		UsersDto dto=new UsersDto();
		dto.setId(users.getId());
		dto.setFirstName(users.getFirstName());
		dto.setLastName(users.getLastName());
		dto.setEmailId(users.getEmailId());
		dto.setPassword(users.getPassword());
		dto.setConfirmPassword(users.getConfirmPassword());
		dto.setContact(users.getContact());
		dto.setAddress(users.getAddress());
		dto.setStates(users.getStates());
		dto.setDelete(users.isDelete());
		
		return dto;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	
	
}
