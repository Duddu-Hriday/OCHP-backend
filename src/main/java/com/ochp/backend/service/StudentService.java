package com.ochp.backend.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ochp.backend.model.Student;
import com.ochp.backend.repo.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository srepo;

	public Student addStudent(Student student, MultipartFile resume, MultipartFile photo) throws IOException {
		// TODO Auto-generated method stub
		student.setResumeName(resume.getOriginalFilename());
		student.setResumeType(resume.getContentType());
		student.setResumeData(resume.getBytes());
		student.setPhotoName(photo.getName());
		student.setPhotoType(photo.getContentType());
		student.setPhotoData(photo.getBytes());
		return srepo.save(student);
		
	}

	public Student getStudent(String roll) {
		// TODO Auto-generated method stub
		return srepo.findById(roll).orElse(null);
//		return null;
	}

}
