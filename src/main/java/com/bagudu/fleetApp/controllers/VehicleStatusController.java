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


import com.bagudu.fleetApp.models.VehicleStatus;
import com.bagudu.fleetApp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@GetMapping("/vehiclestatuses")
	public String getVehicleStatuss(Model model) {
		
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
		model.addAttribute("vehicleStatuss", vehicleStatusList);
				
		return "vehicleStatus";
	}
	
	@PostMapping("/vehiclestatuses/addnew")
	public String addVehicleStatus(VehicleStatus vehicleStatus) {
		
		vehicleStatusService.addVehicleStatus(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}
	
	@RequestMapping("/vehicleStatuses/findbyid")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id){
		
		return vehicleStatusService.findById(id);
	}
	
	@RequestMapping(value="/vehiclestatuses/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleStatus(VehicleStatus vehicleStatus) {
		
		vehicleStatusService.addVehicleStatus(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}
	
	@RequestMapping(value="/vehiclestatuses/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleStatus(Integer id) {		
		vehicleStatusService.delete(id);
		return "redirect:/vehiclestatuses";
	}

}
