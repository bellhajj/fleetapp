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


import com.bagudu.fleetApp.models.VehicleType;
import com.bagudu.fleetApp.services.VehicleTypeService;


@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicletypes")
	public String getVehicleTypes(Model model) {
		
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypeList);
				
		return "vehicleType";
	}
	
	@PostMapping("/vehicletypes/addnew")
	public String addVehicleType(VehicleType vehicleType) {
		
		vehicleTypeService.addVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}
	
	@RequestMapping("/vehicletypes/findbyid")
	@ResponseBody
	public Optional<VehicleType> findById(int id){
		
		return vehicleTypeService.findById(id);
	}
	
	@RequestMapping(value="/vehicletypes/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleType(VehicleType vehicleType) {
		
		vehicleTypeService.addVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}
	
	@RequestMapping(value="/vehicletypes/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleType(Integer id) {		
		vehicleTypeService.delete(id);
		return "redirect:/vehicletypes";
	}

}
