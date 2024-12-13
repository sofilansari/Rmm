package com.ids.argus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.argus.dto.UsersDto;
import com.ids.argus.services.UsersServices;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	private final UsersServices usersServices;

	public UsersController(UsersServices usersServices) {
		
		this.usersServices = usersServices;
	}
	
	
	@GetMapping()
	public List<UsersDto>gettAllUser(){
		return usersServices.gettAllUser();
		
	}

}
