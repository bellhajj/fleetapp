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

import com.bagudu.fleetApp.models.Country;
import com.bagudu.fleetApp.models.Employee;
import com.bagudu.fleetApp.models.Vehicle;
import com.bagudu.fleetApp.models.VehicleMake;
import com.bagudu.fleetApp.models.VehicleModel;
import com.bagudu.fleetApp.models.VehicleStatus;
import com.bagudu.fleetApp.models.VehicleType;
import com.bagudu.fleetApp.services.EmployeeService;
import com.bagudu.fleetApp.services.LocationService;
import com.bagudu.fleetApp.services.VehicleMakeService;
import com.bagudu.fleetApp.services.VehicleModelService;
import com.bagudu.fleetApp.services.VehicleService;
import com.bagudu.fleetApp.services.VehicleStatusService;
import com.bagudu.fleetApp.services.VehicleTypeService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@Autowired
	private EmployeeService employeeService;
	

	@Autowired
	private LocationService locationService;
	
	@GetMapping("/vehicles")
	public String getVehicles(Model model) {
		
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);
		
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		model.addAttribute("vehicleMakes", vehicleMakeList);
		
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModelList);
		
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		model.addAttribute("vehicleTypes", vehicleTypeList);
		
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
		model.addAttribute("vehicleStatuses", vehicleStatusList);
		
		List<Employee> employeeList = employeeService.getEmployees();
		model.addAttribute("employees", employeeList);
		
		return "vehicle";
	}
	
	@PostMapping("/vehicles/addnew")
	public String addVehicle(Vehicle vehicle) {
		
		vehicleService.addVehicle(vehicle);
		return "redirect:/vehicles";
	}
	
	@RequestMapping("/vehicles/findbyid")
	@ResponseBody
	public Optional<Vehicle> findById(int id){
		
		return vehicleService.findById(id);
	}
	
	@RequestMapping(value="/vehicles/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicle(Vehicle vehicle) {		
		vehicleService.addVehicle(vehicle);
		return "redirect:/vehicles";
	}
	
	@RequestMapping(value="/vehicles/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicle(Integer id) {		
		vehicleService.delete(id);
		return "redirect:/vehicles";
	}
}
