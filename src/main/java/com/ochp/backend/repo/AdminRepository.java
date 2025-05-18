package com.ochp.backend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ochp.backend.model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

	Admin findByPassword(String password);

}
