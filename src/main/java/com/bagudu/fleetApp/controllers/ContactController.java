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

import com.bagudu.fleetApp.models.Contact;
import com.bagudu.fleetApp.services.ContactService;


@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	

	
	@GetMapping("/contacts")
	public String getContacts(Model model) {
		
		List<Contact> contactList = contactService.getContacts();
		model.addAttribute("contacts", contactList);
		
		return "contact";
	}
	
	@PostMapping("/contacts/addnew")
	public String addContact(Contact contact) {
		
		contactService.addContact(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping("/contacts/findbyid")
	@ResponseBody
	public Optional<Contact> findById(int id){
		
		return contactService.findById(id);
	}
	
	@RequestMapping(value="/contacts/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateContact(Contact contact) {		
		contactService.addContact(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contacts/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteContact(Integer id) {		
		contactService.delete(id);
		return "redirect:/contacts";
	}
}
