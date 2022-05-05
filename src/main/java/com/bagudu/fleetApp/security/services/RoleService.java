package com.bagudu.fleetApp.security.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.User;
import com.bagudu.fleetApp.repositories.UserRepository;
import com.bagudu.fleetApp.security.models.Role;
import com.bagudu.fleetApp.security.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//Return List of role
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	//Save New Role
	public void addRole(Role role) {
		roleRepository.save(role);
	}
	
	//Edit role
	public Optional<Role> findById(int id) {
		return roleRepository.findById(id);
	}

	//Delete role
	public void delete(Integer id) {
		roleRepository.deleteById(id);
		
	}	
	
	public void assignUserRole(Integer userId, Integer roleId) {
		
		User user = userRepository.findById(userId).orElse(null);
		Role role = roleRepository.findById(roleId).orElse(null);
		
		Set<Role> userRoles = user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		
		userRepository.save(user);
	}
	
	public void unassignUserRole(Integer userId, Integer roleId) {
		
		User user = userRepository.findById(userId).orElse(null);
		Set<Role> userRoles = user.getRoles();
		
		userRoles.removeIf(x -> x.getId() == roleId);
		userRepository.save(user);
	}
	
	public Set<Role> getUserRoles(User user){
		return user.getRoles();
	}
	
	//Roles that are not assigned to the user
	public Set<Role> getUserNotRoles(User user){
		
		return roleRepository.getUserNotRoles(user.getId());
	}
	
	
}
