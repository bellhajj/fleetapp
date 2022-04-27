package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Employee;
import com.bagudu.fleetApp.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
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

}
