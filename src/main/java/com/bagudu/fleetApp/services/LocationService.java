package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Location;
import com.bagudu.fleetApp.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	//Return List of location
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	//Save New Location
	public void addLocation(Location location) {
		locationRepository.save(location);
	}
	
	//Edit location
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	//Delete Location
	public void delete(Integer id) {
		locationRepository.deleteById(id);
		
	}

}
