package com.ids.argus.dto;

import com.ids.argus.model.Contact;

public class ContactDto {
	
	private Long id;
	private String type;
	private String phoneNo;
	private boolean isDeleted;
	
	public ContactDto toDo(Contact contact) {
		
		ContactDto dto=new ContactDto();
		
		dto.setId(contact.getId());
		dto.setType(contact.getType());
		dto.setPhoneNo(contact.getPhoneNo());
		dto.setDeleted(contact.isDeleted());
		
		return dto;
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	

}
