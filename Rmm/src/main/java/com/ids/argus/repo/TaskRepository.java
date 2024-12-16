package com.ids.argus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids.argus.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
