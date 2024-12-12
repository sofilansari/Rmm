package com.ids.argus.dto;

import com.ids.argus.model.Address;

public class AddressDto {
	
	private Long id;
    private String type;
    private Long parentAddressId; // To avoid nested objects
    private String city;
    private String state;
    private String zipcode;
    private Boolean isDeleted;

    // Conversion method from Address entity to AddressDto
    public AddressDto toDo(Address address) {
        if (address == null) {
            return null;
        }
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setType(address.getType());
        dto.setParentAddressId(address.getAddress() != null ? address.getAddress().getId() : null);
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setZipcode(address.getZipcode());
        dto.setIsDeleted(address.getDeleted());
        return dto;
    }

    // Getters and Setters
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

    public Long getParentAddressId() {
        return parentAddressId;
    }

    public void setParentAddressId(Long parentAddressId) {
        this.parentAddressId = parentAddressId;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    

}
