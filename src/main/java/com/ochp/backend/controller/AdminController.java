package com.ochp.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ochp.backend.model.Admin;
import com.ochp.backend.service.AdminService;

@RestController
@CrossOrigin(origins = "https://ochp-frontend.vercel.app", allowCredentials = "true")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService service;
	@PostMapping("/verifyAdmin")
	public ResponseEntity<?> verifyAdmin(@RequestPart("admin") String adminJson)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(adminJson);
//			String name = node.get("name").asText();
			String password = node.get("password").asText();
//			Change here
			Admin a = service.getAdmin(password);
			if (a == null) {
	            return new ResponseEntity<>("Aadmin not found", HttpStatus.NOT_FOUND);
	        }
//			boolean isMatch = BCrypt.checkpw(password, s.getPassword());
//			System.out.println(a.getPassword() + " " + password);
			if(a.getPassword().equals(password))
			{
				return new ResponseEntity<>(a, HttpStatus.OK); 
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			
			
		}
		
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
