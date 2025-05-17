package com.ochp.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="applications")
public class JobApplication {
	
	private String roll;
	private String jobId;
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	@Override
	public String toString() {
		return "JobApplication [roll=" + roll + ", jobId=" + jobId + "]";
	}
	public JobApplication() {
		super();
	}
	
}
