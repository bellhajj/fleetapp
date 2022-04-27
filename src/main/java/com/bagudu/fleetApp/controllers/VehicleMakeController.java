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

import com.bagudu.fleetApp.models.VehicleMake;
import com.bagudu.fleetApp.services.VehicleMakeService;



@Controller
public class VehicleMakeController {
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehiclemakes")
	public String getVehicleMakes(Model model) {
		
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakeList);
		
		return "vehicleMake";
	}
	
	@PostMapping("/vehiclemakes/addnew")
	public String addVehicleMake(VehicleMake vehicleMake) {
		
		vehicleMakeService.addVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}
	
	@RequestMapping("/vehiclemakes/findbyid")
	@ResponseBody
	public Optional<VehicleMake> findById(int id){
		
		return vehicleMakeService.findById(id);
	}
	
	@RequestMapping(value="/vehiclemakes/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMake(VehicleMake vehicleMake) {
		
		vehicleMakeService.addVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}
	
	@RequestMapping(value="/vehiclemakes/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleMake(Integer id) {		
		vehicleMakeService.delete(id);
		return "redirect:/vehiclemakes";
	}

}
