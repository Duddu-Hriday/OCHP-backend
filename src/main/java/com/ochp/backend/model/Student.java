package com.ochp.backend.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
	@Id
	private String id;
	private String name;
	private String roll;
	private String phone;
	private String cemail;
	private String pemail;
//	private String resume;
	private String cpi;
	private String spi;
//	private String photo;
	private String password;
//	private String cpassword;
	private String resumeName;
	private String resumeType;
	private byte[] resumeData;
	private String photoName;
	private String photoType;
	private byte[] photoData;
	
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
	public String getResumeType() {
		return resumeType;
	}
	public void setResumeType(String resmeType) {
		this.resumeType = resmeType;
	}
	public byte[] getResumeData() {
		return resumeData;
	}
	public void setResumeData(byte[] resumeData) {
		this.resumeData = resumeData;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public byte[] getPhotoData() {
		return photoData;
	}
	public void setPhotoData(byte[] photoData) {
		this.photoData = photoData;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getCpi() {
		return cpi;
	}
	public void setCpi(String cpi) {
		this.cpi = cpi;
	}
	public String getSpi() {
		return spi;
	}
	public void setSpi(String spi) {
		this.spi = spi;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getCpassword() {
//		return cpassword;
//	}
//	public void setCpassword(String cpassword) {
//		this.cpassword = cpassword;
//	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", phone=" + phone + ", cemail=" + cemail
				+ ", pemail=" + pemail + ", cpi=" + cpi + ", spi=" + spi + ", password=" + password + ", resumeName=" + resumeName + ", resmeType=" + resumeType + ", resumeData="
				+ Arrays.toString(resumeData) + ", photoName=" + photoName + ", photoType=" + photoType + ", photoData="
				+ Arrays.toString(photoData) + "]";
	}
	public Student() {
		super();
	}
	
	
}
