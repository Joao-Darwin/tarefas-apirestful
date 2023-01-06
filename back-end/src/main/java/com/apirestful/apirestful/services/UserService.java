package com.apirestful.apirestful.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.apirestful.entities.User;
import com.apirestful.apirestful.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findByid(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}
}
