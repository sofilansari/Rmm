package com.ids.argus.dto;

import java.util.List;
import java.util.stream.Collectors;

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
	private boolean status;
	private int states;
	private boolean isDelete;
	
	private List<TaskDto>tasks;
	private List<AddressDto>addresses;
	private List<ContactDto>contacts;
	
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
		
		  if (users.getTasks() != null) {
	            dto.setTasks(users.getTasks().stream()
	                    .map(task -> new TaskDto().toDto(task))
	                    .collect(Collectors.toList()));
	        }
		
		if(users.getAddresses() !=null) {
			dto.setAddresses(users.getAddresses().stream().
					map(address -> new AddressDto().toDto(address)).
					collect(Collectors.toList()));
		}
		
		if(users.getContacts() != null) {
			dto.setContacts(users.getContacts().stream().
					map(contact -> new ContactDto().toDto(contact)).collect(Collectors.toList()));
		}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public List<TaskDto> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDto> tasks) {
		this.tasks = tasks;
	}

	public List<AddressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}

	public List<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactDto> contacts) {
		this.contacts = contacts;
	}

	

	
	
}
