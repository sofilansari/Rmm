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

import com.ids.argus.dto.ContactDto;
import com.ids.argus.services.ContactServices;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	private final ContactServices contactServices;

	public ContactController(ContactServices contactServices) {
		super();
		this.contactServices = contactServices;
	}
	
	@GetMapping()
	public List<ContactDto>getAllContct(){
		
		return contactServices.getAllContct();
		
	}
	
	@GetMapping("/{id}")
	public ContactDto findById(@PathVariable Long id) {
		
		return contactServices.findById(id);
		
	}
	
	@PostMapping("/")
	public ContactDto create(@RequestBody ContactDto contactDto) {
		return contactServices.create(contactDto);
		
	}
	
	@PutMapping("/{id}")
	public ContactDto update(@PathVariable Long id, @RequestBody ContactDto contactDto) {
		return contactServices.update(id, contactDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		
		 contactServices.delete(id);
		
	}

}
