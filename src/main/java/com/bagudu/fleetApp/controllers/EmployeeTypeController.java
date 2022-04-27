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

import com.bagudu.fleetApp.models.EmployeeType;
import com.bagudu.fleetApp.services.EmployeeTypeService;


@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeetypes")
	public String getEmployeeTypes(Model model) {
		
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes", employeeTypeList);
		
		return "employeeType";
	}
	
	@PostMapping("/employeetypes/addnew")
	public String addEmployeeType(EmployeeType employeeType) {
		
		employeeTypeService.addEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}
	
	@RequestMapping("/employeetypes/findbyid")
	@ResponseBody
	public Optional<EmployeeType> findById(int id){
		
		return employeeTypeService.findById(id);
	}
	
	@RequestMapping(value="/employeetypes/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployeeType(EmployeeType employeeType) {
		
		employeeTypeService.addEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}
	
	@RequestMapping(value="/employeetypes/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteEmployeeType(Integer id) {		
		employeeTypeService.delete(id);
		return "redirect:/employeetypes";
	}

}
