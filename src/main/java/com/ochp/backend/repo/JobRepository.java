package com.ochp.backend.repo;

import java.util.*;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ochp.backend.model.Job;

@Repository
public interface JobRepository extends MongoRepository<Job, String>  {
//	Optional<List<Job>> findAllByRoll(String roll);
}
