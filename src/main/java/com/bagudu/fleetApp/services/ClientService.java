package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Client;
import com.bagudu.fleetApp.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	//Return List of client
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	//Save New Client
	public void addClient(Client client) {
		clientRepository.save(client);
	}
	
	//Edit client
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}

	//Delete client
	public void delete(Integer id) {
		clientRepository.deleteById(id);
		
	}
}
