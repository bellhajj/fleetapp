package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.VehicleHire;
import com.bagudu.fleetApp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//Return List of vehicleHire
	public List<VehicleHire> getVehicleHires(){
		return vehicleHireRepository.findAll();
	}
	
	//Save New VehicleHire
	public void addVehicleHire(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	//Edit vehicleHire
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}

	//Delete VehicleHire
	public void delete(Integer id) {
		vehicleHireRepository.deleteById(id);
		
	}

}
