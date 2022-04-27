package com.bagudu.fleetApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bagudu.fleetApp.models.VehicleMovement;
import com.bagudu.fleetApp.models.Location;
import com.bagudu.fleetApp.models.Vehicle;
import com.bagudu.fleetApp.services.VehicleMovementService;
import com.bagudu.fleetApp.services.VehicleService;
import com.bagudu.fleetApp.services.LocationService;

@Controller
public class VehicleMovementController {


	@Autowired
	private VehicleMovementService vehicleMovementService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/vehiclemovements")
	public String getVehicleMovements(Model model) {
		
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
		model.addAttribute("vehicleMovements", vehicleMovementList);
		
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);
		
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
		
		return "vehicleMovement";
	}
	
	@PostMapping("/vehiclemovements/addnew")
	public String addVehicleMovement(VehicleMovement vehicleMovement) {
		
		vehicleMovementService.addVehicleMovement(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping("/vehiclemovements/findbyid")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id){
		
		return vehicleMovementService.findById(id);
	}
	
	@RequestMapping(value="/vehiclemovements/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMovement(VehicleMovement vehicleMovement) {		
		vehicleMovementService.addVehicleMovement(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping(value="/vehiclemovements/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleMovement(Integer id) {		
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}
}
