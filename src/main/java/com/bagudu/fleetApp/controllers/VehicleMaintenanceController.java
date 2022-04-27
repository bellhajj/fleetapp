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

import com.bagudu.fleetApp.models.VehicleMaintenance;
import com.bagudu.fleetApp.models.Supplier;
import com.bagudu.fleetApp.models.Vehicle;
import com.bagudu.fleetApp.services.VehicleMaintenanceService;
import com.bagudu.fleetApp.services.SupplierService;
import com.bagudu.fleetApp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {

	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehiclemaintenances")
	public String getVehicleMaintenances(Model model) {
		
		List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);
		
		List<Supplier> supplierList = supplierService.getSuppliers();
		model.addAttribute("suppliers", supplierList);
		
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);
		
		return "vehicleMaintenance";
	}
	
	@PostMapping("/vehiclemaintenances/addnew")
	public String addVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		
		vehicleMaintenanceService.addVehicleMaintenance(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}
	
	@RequestMapping("/vehiclemaintenances/findbyid")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id){
		
		return vehicleMaintenanceService.findById(id);
	}
	
	@RequestMapping(value="/vehiclemaintenances/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {		
		vehicleMaintenanceService.addVehicleMaintenance(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}
	
	@RequestMapping(value="/vehiclemaintenances/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleMaintenance(Integer id) {		
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehiclemaintenances";
	}

}
