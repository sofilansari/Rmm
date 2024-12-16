package com.ids.argus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.argus.dto.TaskDto;
import com.ids.argus.services.TaskServices;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	private final TaskServices taskServices;

	public TaskController(TaskServices taskServices) {
		super();
		this.taskServices = taskServices;
	}
	
	
	@GetMapping
	public List<TaskDto>getAllTask(){
		return taskServices.getAllTask();
		
	}

	@GetMapping("/{id}")
	public TaskDto findById(@PathVariable Long id) {
		return taskServices.findById(id);
		
	}
	
	@PostMapping("/")
	public TaskDto create(@RequestBody TaskDto taskDto) {
		return taskServices.create(taskDto);
		
	}
	
	@PutMapping("/{id}")
	public TaskDto update(@PathVariable Long id, @RequestBody TaskDto taskDto) {
		return taskServices.update(id,taskDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		taskServices.delete(id);
	}
	
}
