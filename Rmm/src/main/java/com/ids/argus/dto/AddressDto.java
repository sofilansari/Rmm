package com.ids.argus.dto;

import com.ids.argus.model.Address;

public class AddressDto {
	
	private Long id;
	 private String type;
	    private String city;
	    private String state;
	    private String zipcode;
	    private boolean deleted; // Keeping it as Boolean for consistency with the entity

   public AddressDto toDto(Address address) {
	   
	   AddressDto dto=new AddressDto();
	   dto.setId(address.getId());
	   dto.setState(address.getState());
	   dto.setCity(address.getCity());
	   dto.setType(address.getType());
	   dto.setZipcode(address.getZipcode());
	   dto.setDeleted(address.isDeleted());
	   
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

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public boolean isDeleted() {
	return deleted;
}

public void setDeleted(boolean deleted) {
	this.deleted = deleted;
}
   
   
}
