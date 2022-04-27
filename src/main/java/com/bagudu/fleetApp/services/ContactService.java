package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Contact;
import com.bagudu.fleetApp.repositories.ContactRepository;

@Service
public class ContactService {


	@Autowired
	private ContactRepository contactRepository;
	
	//Return List of contact
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	//Save New Contact
	public void addContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	//Edit contact
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

	//Delete contact
	public void delete(Integer id) {
		contactRepository.deleteById(id);
		
	}
}
