package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.VehicleModel;
import com.bagudu.fleetApp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	//Return List of vehicleModel
	public List<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();
	}
	
	//Save New VehicleModel
	public void addVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	//Edit vehicleModel
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	//Delete VehicleModel
	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);
		
	}


}
