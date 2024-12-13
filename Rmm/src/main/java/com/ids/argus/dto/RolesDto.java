package com.ids.argus.dto;

import com.ids.argus.model.Roles;

public class RolesDto {
	
	private Long id;
	private String rolesName;
	
	public RolesDto toDo(Roles roles) {
		RolesDto dto=new RolesDto();
		
		dto.setId(roles.getId());
		dto.setRolesName(roles.getRolesName());
		
		return dto;
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRolesName() {
		return rolesName;
	}
	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}
	
	

}
