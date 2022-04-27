package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Supplier;
import com.bagudu.fleetApp.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Return List of supplier
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}
	
	//Save New Supplier
	public void addSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	//Edit supplier
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	//Delete supplier
	public void delete(Integer id) {
		supplierRepository.deleteById(id);
		
	}

}
