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

import com.ids.argus.dto.AddressDto;
import com.ids.argus.services.AddressServices;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	private final AddressServices addressServices;

	public AddressController(AddressServices addressServices) {
		super();
		this.addressServices = addressServices;
	}
	
	@GetMapping()
	public List<AddressDto>getAllAddress(){
		return addressServices.getAllAddress();
		
	}
	
	@GetMapping("/{id}")
	public AddressDto findById(@PathVariable Long id) {
		return addressServices.findById(id);
		
	}
	
	@PostMapping("/")
	public AddressDto create(@RequestBody AddressDto addressDto) {
		return addressServices.create(addressDto);
		
	}
	
	@PutMapping("/{id}")
	public AddressDto update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
		return addressServices.update(id,addressDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		
		addressServices.delete(id);
	}

}
