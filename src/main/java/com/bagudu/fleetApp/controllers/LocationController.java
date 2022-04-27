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

import com.bagudu.fleetApp.models.Location;
import com.bagudu.fleetApp.models.State;
import com.bagudu.fleetApp.models.Country;
import com.bagudu.fleetApp.services.CountryService;
import com.bagudu.fleetApp.services.LocationService;
import com.bagudu.fleetApp.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/locations")
	public String getLocations(Model model) {
		
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.getStates();		
		model.addAttribute("states", stateList);		
		
		return "location";
	}
	
	@PostMapping("/locations/addnew")
	public String addLocation(Location location) {
		
		locationService.addLocation(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("/locations/findbyid")
	@ResponseBody
	public Optional<Location> findById(int id){
		
		return locationService.findById(id);
	}
	
	@RequestMapping(value="/locations/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateLocation(Location location) {
		
		locationService.addLocation(location);
		return "redirect:/locations";
	}
	
	@RequestMapping(value="/locations/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteLocation(Integer id) {		
		locationService.delete(id);
		return "redirect:/locations";
	}
}
