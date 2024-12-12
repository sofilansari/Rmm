package com.ids.argus.dto;

import com.ids.argus.model.Contact;

public class ContactDto {
	
	private Long id;
	private String name;
	private String stats;
	private String type;
	private boolean isDeleted;
	
	
	public ContactDto toDo(Contact contact) {
		
		ContactDto dto=new ContactDto();
		dto.setId(contact.getId());
		
		return null;
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
		
	
	

}
