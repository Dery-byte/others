package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor


@ToString
@Entity
@Table
public class BloodRequest {
	@Id
	@GeneratedValue
	private int BrId;
	private int age;
	private String disease;
	private String reason;
	private int units;
	private int date;
	
 
	@Enumerated(EnumType.STRING)
	private RequestStatus Rstatus;
	private String roles;
	private String doctorName;
	
	//Constructor
	
	public BloodRequest(int age, String disease, String reason,String doctorName, int units, int date, RequestStatus rstatus,String roles) {
		super();
		this.age = age;
		this.disease = disease;
		this.reason = reason;
		this.units = units;
		this.date = date;
		Rstatus = rstatus;
		this.roles = roles;
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



	/**
	 * @return the brId
	 */
	public int getBrId() {
		return BrId;
	}
	/**
	 * @param brId the brId to set
	 */
	public void setBrId(int brId) {
		BrId = brId;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the disease
	 */
	public String getDisease() {
		return disease;
	}
	/**
	 * @param disease the disease to set
	 */
	public void setDisease(String disease) {
		this.disease = disease;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	/**
	 * @return the date
	 */
	public int getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(int date) {
		this.date = date;
	}
	/**
	 * @return the rstatus
	 */
	public RequestStatus getRstatus() {
		return Rstatus;
	}
	/**
	 * @param rstatus the rstatus to set
	 */
	public void setRstatus(RequestStatus rstatus) {
		Rstatus = rstatus;
	}
	
	//getters and Setters
	
	

}
