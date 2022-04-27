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

import com.bagudu.fleetApp.models.Client;
import com.bagudu.fleetApp.models.Location;
import com.bagudu.fleetApp.models.Vehicle;
import com.bagudu.fleetApp.models.VehicleHire;
import com.bagudu.fleetApp.services.ClientService;
import com.bagudu.fleetApp.services.LocationService;
import com.bagudu.fleetApp.services.VehicleHireService;
import com.bagudu.fleetApp.services.VehicleService;

@Controller
public class VehicleHireController {
	
	@Autowired
	private VehicleHireService vehicleHireService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehiclehires")
	public String getVehicleHires(Model model) {
		
		List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
		model.addAttribute("vehicleHires", vehicleHireList);
		
		List<Client> clientList = clientService.getClients();
		model.addAttribute("clients", clientList);
		
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);
		
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
					
		return "vehicleHire";
	}
	
	@PostMapping("/vehiclehires/addnew")
	public String addVehicleHire(VehicleHire vehicleHire) {
		
		vehicleHireService.addVehicleHire(vehicleHire);
		return "redirect:/vehiclemodels";
	}
	
	@RequestMapping("/vehiclehires/findbyid")
	@ResponseBody
	public Optional<VehicleHire> findById(int id){
		
		return vehicleHireService.findById(id);
	}
	
	@RequestMapping(value="/vehiclehires/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleHire(VehicleHire vehicleHire) {
		
		vehicleHireService.addVehicleHire(vehicleHire);
		return "redirect:/vehiclehires";
	}
	
	@RequestMapping(value="/vehiclehires/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleHire(Integer id) {		
		vehicleHireService.delete(id);
		return "redirect:/vehiclehires";
	}

}
