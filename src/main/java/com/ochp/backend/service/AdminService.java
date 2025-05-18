package com.ochp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochp.backend.model.Admin;
import com.ochp.backend.repo.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository repo;
	
	public Admin getAdmin(String password) {
		return repo.findByPassword(password);
	}
}
