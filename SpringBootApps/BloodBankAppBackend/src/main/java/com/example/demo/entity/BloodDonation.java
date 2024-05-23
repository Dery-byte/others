package com.example.demo.entity;

import javax.persistence.Entity;
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
public class BloodDonation {
	@Id
	@GeneratedValue
	private int dId;
	private String disease;
	private int bUnits;
	private int dAge;
	private int date;
	private BloodGroup bloodgroup;
	private RequestStatus status;
	/**
	 * @return the dId
	 */
	public int getdId() {
		return dId;
	}
	/**
	 * @param dId the dId to set
	 */
	public void setdId(int dId) {
		this.dId = dId;
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
	 * @return the bUnits
	 */
	public int getbUnits() {
		return bUnits;
	}
	/**
	 * @param bUnits the bUnits to set
	 */
	public void setbUnits(int bUnits) {
		this.bUnits = bUnits;
	}
	/**
	 * @return the dAge
	 */
	public int getdAge() {
		return dAge;
	}
	/**
	 * @param dAge the dAge to set
	 */
	public void setdAge(int dAge) {
		this.dAge = dAge;
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
	 * @return the bloodgroup
	 */
	public BloodGroup getBloodgroup() {
		return bloodgroup;
	}
	/**
	 * @param bloodgroup the bloodgroup to set
	 */
	public void setBloodgroup(BloodGroup bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	/**
	 * @return the status
	 */
	public RequestStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	
	
	//Getters and Setters
	
	
}
