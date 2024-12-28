package com.ids.argus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String rolesName;

    // Many roles can be assigned to one user
    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key in the Roles table
    private User user;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(Long id, String rolesName, User user) {
		super();
		this.id = id;
		this.rolesName = rolesName;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	
}
