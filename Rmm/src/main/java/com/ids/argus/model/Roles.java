package com.ids.argus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles extends BaseAuditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rolesName;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(Long id, String rolesName) {
		super();
		this.id = id;
		this.rolesName = rolesName;
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
