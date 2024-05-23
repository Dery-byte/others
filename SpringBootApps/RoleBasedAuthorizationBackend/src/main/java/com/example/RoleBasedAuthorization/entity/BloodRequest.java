package com.example.RoleBasedAuthorization.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="BloodRequest")
public class BloodRequest {
	
    @Id
	@GeneratedValue
	private int RquestId;
	private String doctorName; // this will map a doctor to blood request
	private String roles;
	private int age;
	private String disease;
	private String reason;
//	private String date;
	private int units;
	@Enumerated(EnumType.STRING)
	private BloodRequestStatus status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date requestDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date approvedDate;
	private String bloodgroup;
	
//	

	//
	@PrePersist()
	private void onCreate() {
		requestDate = new Date();
		approvedDate = new Date(00000000000000);
}
		
	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}	




	

	public int getRquestId() {
		return RquestId;
	}

	public void setRquestId(int rquestId) {
		RquestId = rquestId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}



	public BloodRequestStatus getStatus() {
		return status;
	}

	public void setStatus(BloodRequestStatus status) {
		this.status = status;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	
	
	
	
}