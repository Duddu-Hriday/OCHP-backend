package com.ochp.backend.repo;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ochp.backend.model.JobApplication;

@Repository
public interface JobApplicationRepository extends MongoRepository<JobApplication, String> {

	Optional<JobApplication> findByRollAndJobId(String roll, String jobId);
	List<JobApplication> findAllByRoll(String roll);
}
