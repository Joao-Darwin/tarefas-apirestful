package com.apirestful.apirestful.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.apirestful.entities.Task;
import com.apirestful.apirestful.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public Task insert(Task task) {
		return taskRepository.save(task);
	}
}
