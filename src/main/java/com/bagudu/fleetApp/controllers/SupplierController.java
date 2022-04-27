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

import com.bagudu.fleetApp.models.Supplier;
import com.bagudu.fleetApp.models.Country;
import com.bagudu.fleetApp.models.State;
import com.bagudu.fleetApp.services.SupplierService;
import com.bagudu.fleetApp.services.CountryService;
import com.bagudu.fleetApp.services.StateService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {
		
		List<Supplier> supplierList = supplierService.getSuppliers();
		model.addAttribute("suppliers", supplierList);
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.getStates();
		model.addAttribute("states", stateList);
		
		return "supplier";
	}
	
	@PostMapping("/suppliers/addnew")
	public String addSupplier(Supplier supplier) {
		
		supplierService.addSupplier(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping("/suppliers/findbyid")
	@ResponseBody
	public Optional<Supplier> findById(int id){
		
		return supplierService.findById(id);
	}
	
	@RequestMapping(value="/suppliers/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateSupplier(Supplier supplier) {		
		supplierService.addSupplier(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping(value="/suppliers/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteSupplier(Integer id) {		
		supplierService.delete(id);
		return "redirect:/suppliers";
	}
}
