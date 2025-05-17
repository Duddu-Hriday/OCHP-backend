package com.ochp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ochp.backend.model.Job;
import com.ochp.backend.service.JobService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class JobController {
	
	@Autowired
	private JobService js;	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getJobs()
	{
		return new ResponseEntity<>(js.getJobs(), HttpStatus.OK);
	}
	
	@GetMapping("/job/{id}")
	public ResponseEntity<Job> getJob(@PathVariable String id)
	{
		return new ResponseEntity<>(js.getJob(id), HttpStatus.OK);
	}
	@GetMapping("/appliedjobs")
	public ResponseEntity<List<Job>> appliedJobs(@RequestParam("id") String id)
	{
		return new ResponseEntity<>(js.appliedJobs(id), HttpStatus.OK);
		
	}
}
