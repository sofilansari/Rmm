package com.ids.argus.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ids.argus.dto.TaskDto;
import com.ids.argus.model.Task;
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
		List<Task>tastOfList=taskRepository.findAll();
		return tastOfList.stream().map(tast -> new TaskDto().toDo(tast)).
				collect(Collectors.toList());
	}

	@Override
	public TaskDto findById(Long id) {
		Task tast=taskRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Tast not found with id "+ id));
		return new TaskDto().toDo(tast);
	}

	@Override
	public TaskDto create(TaskDto taskDto) {
		Task savedTask=new Task();
		savedTask.setId(taskDto.getId());
		savedTask.setTaskName(taskDto.getTaskName());
		savedTask.setState(taskDto.isState());
		savedTask.setDelete(taskDto.isDelete());
		savedTask.setPractices(taskDto.isPractices());
		
		Task task=taskRepository.save(savedTask);
		return new TaskDto().toDo(task);
	}

	@Override
	public TaskDto update(Long id, TaskDto taskDto) {
		Task exisitingTask=taskRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Task not found with id" + id));
		
		exisitingTask.setId(taskDto.getId());
		exisitingTask.setTaskName(taskDto.getTaskName());
		exisitingTask.setState(taskDto.isState());
		exisitingTask.setDelete(taskDto.isDelete());
		exisitingTask.setPractices(taskDto.isPractices());
		
		Task savedExisiting=taskRepository.save(exisitingTask);
		return new TaskDto().toDo(savedExisiting);
	}

	@Override
	public void delete(Long id) {
		Task delete=taskRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Task not found with id"+ id));
		
		taskRepository.delete(delete);
		
	}	

}
