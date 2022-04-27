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

import com.bagudu.fleetApp.models.InvoiceStatus;
import com.bagudu.fleetApp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoicestatuses")
	public String getInvoiceStatuss(Model model) {
		
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
		model.addAttribute("invoiceStatuses", invoiceStatusList);		
		
		return "invoiceStatus";
	}
	
	@PostMapping("/invoicestatuses/addnew")
	public String addInvoiceStatus(InvoiceStatus invoiceStatus) {
		
		invoiceStatusService.addInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatuses";
	}
	
	@RequestMapping("invoicestatuses/findbyid")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id){
		
		return invoiceStatusService.findById(id);
	}
	
	@RequestMapping(value="/invoicestatuses/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
		
		invoiceStatusService.addInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatuses";
	}
	
	@RequestMapping(value="invoicestatuses/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteInvoiceStatus(Integer id) {		
		invoiceStatusService.delete(id);
		return "redirect:/invoicestatuses";
	}

}
