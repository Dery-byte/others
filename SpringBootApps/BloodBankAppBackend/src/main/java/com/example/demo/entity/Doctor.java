package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

@ToString
@Entity
@Table
public class Doctor {



	@Id
	@GeneratedValue
	private int DocId;
	private String docName;
	private String hospital;
	private String roles;
	private String userName;
	private String password;
	private boolean active;
	
	//Constructors
	public Doctor(String docName, String hospital,String roles,String userName,String password,boolean active) {
		super();
		this.docName = docName;
		this.hospital = hospital;
		this.roles = roles;
		this.userName = userName;
		this.password = password;
		this.active = active;
	}
	
	//Getters and setters
	
	public int getDocId() {
		return DocId;
	}

	public void setDocId(int docId) {
		DocId = docId;
	}

	
	
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}






	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}





	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}





	@OneToMany(targetEntity=Patient.class, cascade = CascadeType.ALL )
	@JoinColumn(name="DockPatient_fk", referencedColumnName="DocId")
	
	private List<Patient> patient;
	
	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	
	@OneToMany(targetEntity=BloodRequest.class, cascade = CascadeType.ALL )
	@JoinColumn(name="bloodrequest_fk", referencedColumnName="DocId")
	private List<BloodRequest> bloodrequest;

	public List<BloodRequest> getBloodrequest() {
		return bloodrequest;
	}

	public void setBloodrequest(List<BloodRequest> bloodrequest) {
		this.bloodrequest = bloodrequest;
	}

	

	
}
