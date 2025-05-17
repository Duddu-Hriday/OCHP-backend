package com.ochp.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document(collection="jobs")
public class Job {
	
//	@Id
	private String id;
	private String companyName;
	private String location;
	private String role;
	private String rCPI;
	private String ctc;
	private String interviewDate;
	private String joiningDate;
	private String interviewRounds;
	private String conditions;
	public Job() {
		super();
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", companyName=" + companyName + ", location=" + location + ", role=" + role
				+ ", rCPI=" + rCPI + ", ctc=" + ctc + ", interviewDate=" + interviewDate + ", joiningDate="
				+ joiningDate + ", interviewRounds=" + interviewRounds + ", conditions=" + conditions + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getrCPI() {
		return rCPI;
	}
	public void setrCPI(String rCPI) {
		this.rCPI = rCPI;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getInterviewRounds() {
		return interviewRounds;
	}
	public void setInterviewRounds(String interviewRounds) {
		this.interviewRounds = interviewRounds;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
}
