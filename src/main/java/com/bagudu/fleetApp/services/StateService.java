package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.State;
import com.bagudu.fleetApp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	//Return List of state
	public List<State> getStates(){
		return stateRepository.findAll();
	}
	
	//Save New State
	public void addState(State state) {
		stateRepository.save(state);
	}
	
	//Edit state
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

	//Delete state
	public void delete(Integer id) {
		stateRepository.deleteById(id);
		
	}
}
