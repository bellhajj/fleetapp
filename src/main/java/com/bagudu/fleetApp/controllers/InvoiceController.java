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

import com.bagudu.fleetApp.models.Client;
import com.bagudu.fleetApp.models.Invoice;
import com.bagudu.fleetApp.models.InvoiceStatus;

import com.bagudu.fleetApp.services.ClientService;
import com.bagudu.fleetApp.services.InvoiceService;
import com.bagudu.fleetApp.services.InvoiceStatusService;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoices")
	public String getInvoices(Model model) {
		
		List<Invoice> invoiceList = invoiceService.getInvoices();
		model.addAttribute("invoices", invoiceList);
		
		List<Client> clientList = clientService.getClients();
		model.addAttribute("clients", clientList);
		
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
		model.addAttribute("invoiceStatuses", invoiceStatusList);
		
		return "invoice";
	}
	
	@PostMapping("/invoices/addnew")
	public String addInvoice(Invoice invoice) {
		
		invoiceService.addInvoice(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping("/invoices/findbyid")
	@ResponseBody
	public Optional<Invoice> findById(int id){
		
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value="/invoices/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateInvoice(Invoice invoice) {		
		invoiceService.addInvoice(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value="/invoices/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteInvoice(Integer id) {		
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
