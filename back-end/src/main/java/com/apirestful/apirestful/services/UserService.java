package com.apirestful.apirestful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.apirestful.entities.User;
import com.apirestful.apirestful.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public User findByid(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}
	
	public List<User> findAll() {
		List<User> listUser = userRepository.findAll();
		return listUser;
	}
	
	public User updateUser(Long id, User user) {
		User userEdit = findByid(id);
		
		updateDate(userEdit, user);
		
		return userRepository.save(userEdit);
	}
	
	public void updateDate(User userEdit, User user) {
		userEdit.setName(user.getName());
		userEdit.setEmail(user.getEmail());
		userEdit.setPassword(user.getPassword());
		userEdit.setPhone(user.getPhone());
	}
}
