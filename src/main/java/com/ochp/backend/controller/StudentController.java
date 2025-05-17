package com.ochp.backend.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ochp.backend.model.Student;
import com.ochp.backend.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
//	@GetMapping("/hello")
//	public String sayHello()
//	{
//		return "Hello World";
//	}
	
//	@PostMapping("/addStudent")
	@PostMapping(value = "/addStudent", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addStudent(@RequestPart("student") String studentJson, @RequestPart("resume") MultipartFile resume, @RequestPart("photo") MultipartFile photo)
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
			Student s = mapper.readValue(studentJson, Student.class);
			Student check = service.getStudent(s.getRoll());
			if(check!=null)
			{
				return new ResponseEntity<>("Student data Exists", HttpStatus.BAD_REQUEST);
			}
			s.setPassword(BCrypt.hashpw(s.getPassword(), BCrypt.gensalt()));
			Student saved = service.addStudent(s, resume, photo);
			return new ResponseEntity<>(saved, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/verifyStudent")
	public ResponseEntity<?> verifyStudent(@RequestPart("student") String studentJson)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(studentJson);
			String roll = node.get("roll").asText();
			String password = node.get("password").asText();
			Student s = service.getStudent(roll);
			if (s == null) {
	            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	        }
			boolean isMatch = BCrypt.checkpw(password, s.getPassword());
			if(isMatch)
			{
				return new ResponseEntity<>(s, HttpStatus.OK); 
			}
			else
			{
				return new ResponseEntity<>(new Student(), HttpStatus.UNAUTHORIZED);
			}
			
			
		}
		
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
