package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.VehicleType;
import com.bagudu.fleetApp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	//Return List of vehicleType
	public List<VehicleType> getVehicleTypes(){
		return vehicleTypeRepository.findAll();
	}
	
	//Save New VehicleType
	public void addVehicleType(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	//Edit vehicleType
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	//Delete VehicleType
	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
		
	}


}
