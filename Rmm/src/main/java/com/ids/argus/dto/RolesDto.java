package com.ids.argus.dto;

import com.ids.argus.model.Roles;

public class RolesDto {
	
	    private Long id;
	    private String rolesName;

	    // Mapping Role entity to RolesDto
	    public RolesDto toDo(Roles role) {
	        RolesDto dto = new RolesDto();
	        dto.setId(role.getId());
	        dto.setRolesName(role.getRolesName());
	        return dto;
	    }

	    // Getters and Setters
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
