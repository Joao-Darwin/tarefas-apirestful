package com.apirestful.apirestful.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestful.apirestful.entities.User;
import com.apirestful.apirestful.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		User nUser = userService.insert(user);
		return ResponseEntity.ok().body(nUser);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User nUser = userService.findByid(id);
		return ResponseEntity.ok().body(nUser);
	}
}
