package com.ids.argus.dto;

import com.ids.argus.model.Roles;

public class RolesDto {
	
<<<<<<< HEAD
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
=======
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
>>>>>>> 77ff4358526ff82ab85ece956cb3cdda6d43ad79
	
	
	

}
