package com.bagudu.fleetApp.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Country;
import com.bagudu.fleetApp.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	//Return List of Countries
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}
	
	//Save New Country
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	//Edit country
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}

	//Delete Country
	public void delete(Integer id) {
		countryRepository.deleteById(id);
		
	}

}
