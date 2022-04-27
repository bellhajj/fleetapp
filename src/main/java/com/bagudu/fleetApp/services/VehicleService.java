package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Vehicle;
import com.bagudu.fleetApp.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//Return List of vehicle
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}
	
	//Save New Vehicle
	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	//Edit vehicle
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	//Delete vehicle
	public void delete(Integer id) {
		vehicleRepository.deleteById(id);
		
	}
}
