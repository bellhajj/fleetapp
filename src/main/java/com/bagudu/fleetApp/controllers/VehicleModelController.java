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


import com.bagudu.fleetApp.models.VehicleModel;
import com.bagudu.fleetApp.services.VehicleModelService;


@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehiclemodels")
	public String getVehicleModels(Model model) {
		
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModelList);
					
		return "vehicleModel";
	}
	
	@PostMapping("/vehiclemodels/addnew")
	public String addVehicleModel(VehicleModel vehicleModel) {
		
		vehicleModelService.addVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}
	
	@RequestMapping("/vehiclemodels/findbyid")
	@ResponseBody
	public Optional<VehicleModel> findById(int id){
		
		return vehicleModelService.findById(id);
	}
	
	@RequestMapping(value="/vehiclemodels/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleModel(VehicleModel vehicleModel) {
		
		vehicleModelService.addVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}
	
	@RequestMapping(value="/vehiclemodels/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleModel(Integer id) {		
		vehicleModelService.delete(id);
		return "redirect:/vehiclemodels";
	}

}
