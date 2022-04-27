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

import com.bagudu.fleetApp.models.JobTitle;
import com.bagudu.fleetApp.services.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping("/jobtitles")
	public String getJobTitles(Model model) {
		
		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles", jobTitleList);
				
		return "jobTitle";
	}
	
	@PostMapping("/jobtitles/addnew")
	public String addJobTitle(JobTitle jobTitle) {
		
		jobTitleService.addJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}
	
	@RequestMapping("/jobtitles/findbyid")
	@ResponseBody
	public Optional<JobTitle> findById(int id){
		
		return jobTitleService.findById(id);
	}
	
	@RequestMapping(value="/jobtitles/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateJobTitle(JobTitle jobTitle) {
		
		jobTitleService.addJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}
	
	@RequestMapping(value="/jobtitles/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteJobTitle(Integer id) {		
		jobTitleService.delete(id);
		return "redirect:/jobtitles";
	}

}
