package com.ochp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ochp.backend.model.JobApplication;
import com.ochp.backend.service.JobApplicationService;

@RestController
@CrossOrigin(origins = "https://ochp-frontend.vercel.app", allowCredentials = "true")
@RequestMapping("/api")
public class JobApplicationController {
	
	@Autowired
	JobApplicationService jas;
	
	@PostMapping("/addApplication")
	public ResponseEntity<?> addApplication(@RequestPart("jobApplication") String jobApplicationJson) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		JobApplication job = mapper.readValue(jobApplicationJson, JobApplication.class);
		JobApplication saved = jas.addApplication(job);
		if(saved == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(saved,HttpStatus.OK);
	}

}
