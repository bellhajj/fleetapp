package com.bagudu.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.fleetApp.models.JobTitle;
import com.bagudu.fleetApp.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	//Return List of jobTitle
	public List<JobTitle> getJobTitles(){
		return jobTitleRepository.findAll();
	}
	
	//Save New JobTitle
	public void addJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
	//Edit jobTitle
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

	//Delete JobTitle
	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
		
	}


}
