package com.apirestful.apirestful.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.apirestful.entities.Task;
import com.apirestful.apirestful.repositories.TaskRepository;
import com.apirestful.apirestful.services.execptions.ResourceNotFoundExecption;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public Task insert(Task task) {
		return taskRepository.save(task);
	}
	
	public Task findById(Long id) {
		try {
			Task task = taskRepository.findById(id).get();
			return task;
		} catch(NoSuchElementException e) {
			throw new ResourceNotFoundExecption(id);
		} catch(Exception e) {
			throw new ResourceNotFoundExecption(id);
		}
	}
	
	public List<Task> findAll() {
		List<Task> list = taskRepository.findAll();
		return list;
	}
	
	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}
	
	public void deleteAll() {
		taskRepository.deleteAll();
	}
	
	public Task update(Long id, Task task) {
		Task oldTask = findById(id);
		
		updateDate(task, oldTask);
		
		return taskRepository.save(oldTask);
		
	}
	
	public static void updateDate(Task task, Task oldTask) {
		oldTask.setName(task.getName());
		oldTask.setDescription(task.getDescription());
		oldTask.setTaskStatus(task.getStatus());
		oldTask.setDate(task.getDate());
		oldTask.setUser(task.getUser());
	}
}
