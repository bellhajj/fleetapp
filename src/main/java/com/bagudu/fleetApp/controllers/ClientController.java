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
import com.bagudu.fleetApp.models.State;
import com.bagudu.fleetApp.models.Client;
import com.bagudu.fleetApp.services.CountryService;
import com.bagudu.fleetApp.services.StateService;
import com.bagudu.fleetApp.services.ClientService;

@Controller
public class ClientController {


	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/clients")
	public String getClients(Model model) {
		
		List<Client> clientList = clientService.getClients();
		model.addAttribute("clients", clientList);
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		
		List<State> stateList = stateService.getStates();
		model.addAttribute("states", stateList);
		
		return "client";
	}
	
	@PostMapping("/clients/addnew")
	public String addClient(Client client) {
		
		clientService.addClient(client);
		return "redirect:/clients";
	}
	
	@RequestMapping("/clients/findbyid")
	@ResponseBody
	public Optional<Client> findById(int id){
		
		return clientService.findById(id);
	}
	
	@RequestMapping(value="/clients/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateClient(Client client) {		
		clientService.addClient(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="/clients/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteClient(Integer id) {		
		clientService.delete(id);
		return "redirect:/clients";
	}
}
