package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.Invoice;
import com.bagudu.fleetApp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//Return List of invoice
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
	}
	
	//Save New Invoice
	public void addInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	//Edit invoice
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}

	//Delete invoice
	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
		
	}

}
