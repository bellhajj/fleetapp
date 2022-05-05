package com.bagudu.fleetApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bagudu.fleetApp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
	
	public User findByFirstnameAndLastname(String firstname, String lastname);

}
