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

import com.bagudu.fleetApp.models.JobTitle;
import com.bagudu.fleetApp.models.State;
import com.bagudu.fleetApp.models.Country;
import com.bagudu.fleetApp.models.Employee;
import com.bagudu.fleetApp.models.EmployeeType;
import com.bagudu.fleetApp.services.EmployeeTypeService;
import com.bagudu.fleetApp.services.CountryService;
import com.bagudu.fleetApp.services.EmployeeService;
import com.bagudu.fleetApp.services.JobTitleService;
import com.bagudu.fleetApp.services.StateService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobTitleService jobTitleService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		
		List<Employee> employeeList = employeeService.getEmployees();
		model.addAttribute("employees", employeeList);
		
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes", employeeTypeList);
		
		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();		
		model.addAttribute("jobTitles", jobTitleList);	
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.getStates();		
		model.addAttribute("states", stateList);	
		
		return "employee";
	}
	
	@PostMapping("/employees/addnew")
	public String addEmployee(Employee employee) {
		
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping("/employees/findbyid")
	@ResponseBody
	public Optional<Employee> findById(int id){
		
		return employeeService.findById(id);
	}
	
	@RequestMapping(value="/employees/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployee(Employee employee) {
		
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value="/employees/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteEmployee(Integer id) {		
		employeeService.delete(id);
		return "redirect:/employees";
	}
}
