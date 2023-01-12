package com.apirestful.apirestful.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestful.apirestful.entities.Task;
import com.apirestful.apirestful.services.TaskService;

@RestController
@RequestMapping(value = "/task")
public class TaskResource {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<Task> insert(@RequestBody Task task) {
		task = taskService.insert(task);
		return ResponseEntity.ok().body(task);
	}
}
