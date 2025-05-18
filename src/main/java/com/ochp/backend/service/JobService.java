package com.ochp.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochp.backend.model.Job;
import com.ochp.backend.model.JobApplication;
import com.ochp.backend.repo.JobApplicationRepository;
import com.ochp.backend.repo.JobRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository repo;
	@Autowired
	private JobApplicationRepository apprepo;
	public List<Job> getJobs() {
		// TODO Auto-generated method stub
//		return repo.findAll();
		List<Job> jobs = repo.findAll();
		if(jobs!=null)
		{
			return jobs;
		}
		else
		{
			return new ArrayList<Job>();
		}
		
	}
	public Job getJob(String id) {
		System.out.println(id);
		Job job = repo.findById(id).orElse(new Job());
		return job;
	}
	
	public List<Job> appliedJobs(String id) {
		List<JobApplication> applications = apprepo.findAllByRoll(id);
		List<Job> applied = new ArrayList<>();
		for(JobApplication application:applications)
		{
			applied.add(repo.findById(application.getJobId()).orElse(null));
		}
		return applied;
	}
	public Job addJob(Job job) {
		return repo.save(job);
	}

}
