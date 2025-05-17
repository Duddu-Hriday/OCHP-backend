package com.ochp.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochp.backend.model.JobApplication;
import com.ochp.backend.repo.JobApplicationRepository;

@Service
public class JobApplicationService {
	
	@Autowired
	private JobApplicationRepository repo;

	public JobApplication addApplication(JobApplication jobApplication) {
		Optional<JobApplication> existing = repo.findByRollAndJobId(jobApplication.getRoll(), jobApplication.getJobId());
		
//		System.out.println("Exists or not? :" + existing);
		if(!existing.isPresent())
		{
			repo.save(jobApplication);
			return jobApplication;
		}
		
		return null;
		
		
	}

}
