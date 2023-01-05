package com.apirestful.apirestful.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apirestful.apirestful.entities.User;
import com.apirestful.apirestful.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Darwin", "joaodarwin.ip22@gmail.com", "88 9 99950601", "darwin@123");
		User u2 = new User(null, "Isabelly", "isabelly.ip23@gmail.com", "88 9 998753456", "isabelly@123");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

	

}
