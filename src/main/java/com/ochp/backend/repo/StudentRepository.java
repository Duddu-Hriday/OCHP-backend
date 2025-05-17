package com.ochp.backend.repo;

import org.springframework.stereotype.Repository;

import com.ochp.backend.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
