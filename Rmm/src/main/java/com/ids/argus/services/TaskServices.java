package com.ids.argus.services;

import java.util.List;

import com.ids.argus.dto.TaskDto;

public interface TaskServices {

	public List<TaskDto> getAllTask();

	public TaskDto findById(Long id);

	public TaskDto create(TaskDto taskDto);

	public TaskDto update(Long id, TaskDto taskDto);

	public void delete(Long id);

}
