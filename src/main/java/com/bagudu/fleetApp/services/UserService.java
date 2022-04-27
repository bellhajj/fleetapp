package com.bagudu.fleetApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.User;
import com.bagudu.fleetApp.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	//Save New User
	public void addUser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
