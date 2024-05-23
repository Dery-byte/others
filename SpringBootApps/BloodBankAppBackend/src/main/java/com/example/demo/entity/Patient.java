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
public class Patient {
	@Id
	@GeneratedValue
	private int pId;
	private String pName;
	private String pAge;
	private String pDisease;
	private String address;
	private String pMobile;
	private BloodGroup pBloodGroup;
	private String role;
	
	
	
	
	//Constructor
	
	public Patient(String pName, String pAge, String pDisease,  String role, String address, String pMobile, BloodGroup pBloodGroup) {
		super();
		this.pName = pName;
		this.pAge = pAge;
		this.pDisease = pDisease;
		this.address = address;
		this.pMobile = pMobile;
		this.pBloodGroup = pBloodGroup;
		this.role = role;
	}
	
	
	
	
	
	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}
	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}
	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * @return the pAge
	 */
	public String getpAge() {
		return pAge;
	}
	/**
	 * @param pAge the pAge to set
	 */
	public void setpAge(String pAge) {
		this.pAge = pAge;
	}
	/**
	 * @return the pDisease
	 */
	public String getpDisease() {
		return pDisease;
	}
	/**
	 * @param pDisease the pDisease to set
	 */
	public void setpDisease(String pDisease) {
		this.pDisease = pDisease;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the pMobile
	 */
	public String getpMobile() {
		return pMobile;
	}
	/**
	 * @param pMobile the pMobile to set
	 */
	public void setpMobile(String pMobile) {
		this.pMobile = pMobile;
	}
	/**
	 * @return the pBloodGroup
	 */
	public BloodGroup getpBloodGroup() {
		return pBloodGroup;
	}
	/**
	 * @param pBloodGroup the pBloodGroup to set
	 */
	public void setpBloodGroup(BloodGroup pBloodGroup) {
		this.pBloodGroup = pBloodGroup;
	}





	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	
	//Getters and Setters
	
	
	
}
