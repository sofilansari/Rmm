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

import com.ids.argus.dto.NotificationDto;
import com.ids.argus.services.NotificationServices;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

	private final NotificationServices notificationServices;

	public NotificationController(NotificationServices notificationServices) {
		super();
		this.notificationServices = notificationServices;
	}
		
	@GetMapping()
		public List<NotificationDto>getAllNotification(){
			
			return notificationServices.getAllNotification();
			
		}
	
	@GetMapping("/{id}")
	public NotificationDto findById(@PathVariable Long id) {
		return notificationServices.findById(id);
		
	}
	
	@PostMapping("/")
	public NotificationDto create(@RequestBody NotificationDto notificationDto) {
		return notificationServices.create(notificationDto);
		
	}
	
	
	@PutMapping("/{id}")
	public NotificationDto update(@PathVariable Long id, @RequestBody NotificationDto notificationDto) {
		return notificationServices.update(id, notificationDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		
		notificationServices.delete(id);
	}
}
