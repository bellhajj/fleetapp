package com.bagudu.fleetApp.services;

import java.util.List;

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
	
	//Get User By Id
	public User findById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//Get All Users
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	//Delete User
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	//Update User
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
