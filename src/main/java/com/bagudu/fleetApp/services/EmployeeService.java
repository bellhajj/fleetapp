package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Employee;
import com.bagudu.fleetApp.models.User;
import com.bagudu.fleetApp.repositories.EmployeeRepository;
import com.bagudu.fleetApp.repositories.UserRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
		
	//Return List of employee
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	//Save New Employee
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	//Edit employee
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	//Delete Employee
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
		
	}

	public Employee findByUsername(String username) {
		
		return employeeRepository.findByUsername(username);
	}
	
	//Set the username of the employee where firstname and lastname match
	public void assignUsername(int id) {
		
		Employee employee = employeeRepository.findById(id).orElse(null);
		User user = userRepository.findByFirstnameAndLastname(employee.getFirstname(), employee.getLastname());
		employee.setUsername(user.getUsername());
		employeeRepository.save(employee);
	}
	
	

}
