package com.ids.argus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ids.argus.dto.DoctorDto;
import com.ids.argus.services.DoctorServices;

@RestController
@RequestMapping("/api/docter")
public class DoctorController {

	@Autowired
	private  DoctorServices doctorServices;

	@GetMapping("/filter")
	public List<DoctorDto> getDoctorsByStatus(@RequestParam boolean status){
		return doctorServices.getDoctorsByStatus(status);
		
	}

	@GetMapping()
	public List<DoctorDto> getAllDoctor(){
		
		return doctorServices.getAllDoctor();
		
	}
	
	@GetMapping("/{id}")
	public DoctorDto findById(@PathVariable Long id) {
		return doctorServices.findById(id);
		
	}
	
	@PostMapping("/")
	public DoctorDto create(@RequestBody DoctorDto doctorDto) {
		
		return doctorServices.create(doctorDto);
		
	}
	
	@PutMapping("/{id}")
	public DoctorDto update(@RequestBody DoctorDto doctorDto, @PathVariable Long id) {
		return doctorServices.update(doctorDto, id);
		
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		doctorServices.delete(id);
	}
}
