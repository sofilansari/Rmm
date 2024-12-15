package com.ids.argus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.argus.dto.RolesDto;
import com.ids.argus.services.RolesServices;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
	
	private final RolesServices rolesServices;

	public RolesController(RolesServices rolesServices) {
		super();
		this.rolesServices = rolesServices;
	}
	
	public List<RolesDto>getAllRoles(){
		return rolesServices.getAllRoles();
		
	}
	
	@GetMapping("/{id}")
	public RolesDto findById(@PathVariable Long id) {
		return rolesServices.findById(id);
		
	}
	
	@PostMapping("/")
	public RolesDto create(@RequestBody RolesDto rolesDto) {
		return rolesServices.crete(rolesDto);
		
	}

	@PutMapping("/{id}")
	public RolesDto update(@PathVariable Long id, @RequestBody RolesDto rolesDto) {
		return rolesServices.update(id, rolesDto);
		
	}
	
	public void delete(@PathVariable Long id) {
		rolesServices.delete(id);
	}
}
