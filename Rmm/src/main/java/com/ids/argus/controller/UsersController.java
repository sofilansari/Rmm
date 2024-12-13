package com.ids.argus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.argus.dto.UsersDto;
import com.ids.argus.services.UsersServices;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private final UsersServices usersServices;

	public UsersController(UsersServices usersServices) {
		
		this.usersServices = usersServices;
	}
	
	
	@GetMapping()
	public List<UsersDto>gettAllUser(){
		return usersServices.gettAllUser();
		
	}
	
	@GetMapping("/{id}")
	public UsersDto findById(@PathVariable Long id) {
		return usersServices.findById(id);
		
	}
	
	@PostMapping("/")
	public UsersDto create(@RequestBody UsersDto usersDto) {
		return usersServices.create(usersDto);
		
	}
	
	@PutMapping("/{id}")
	public UsersDto update(@PathVariable Long id, @RequestBody UsersDto usersDto) {
		return usersServices.update(id,usersDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		
		usersServices.delete(id);
	}

}
