package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.EmployeeType;
import com.bagudu.fleetApp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//Return List of employeeType
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}
	
	//Save New EmployeeType
	public void addEmployeeType(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	//Edit employeeType
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	//Delete EmployeeType
	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
		
	}


}
