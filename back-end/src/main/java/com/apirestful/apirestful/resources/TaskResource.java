package com.apirestful.apirestful.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		Task nTask = taskService.findById(id);
		return ResponseEntity.ok().body(nTask);
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		List<Task> list = taskService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
