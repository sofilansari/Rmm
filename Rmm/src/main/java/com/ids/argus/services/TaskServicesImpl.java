package com.ids.argus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.TaskDto;
import com.ids.argus.repo.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskServicesImpl implements TaskServices{
	
	private final TaskRepository taskRepository;

	public TaskServicesImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public List<TaskDto> getAllTask() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDto create(TaskDto taskDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDto update(Long id, TaskDto taskDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
