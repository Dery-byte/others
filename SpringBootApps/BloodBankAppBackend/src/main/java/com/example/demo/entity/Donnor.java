package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Donnor {
	
	@Id
	@GeneratedValue
	private int DoId;
	private int age;
	private String disease;
	private String address;
	private String mobileNumber;
	private BloodGroup  bloodgroup;
	private String UserName;
	private String roles;
	private String password;
	
	
	//Constructors
	
	public Donnor(int age, String disease,String UserName,String roles, String password, String address, String mobileNumber, BloodGroup bloodgroup) {
		super();
		this.age = age;
		this.disease = disease;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.bloodgroup = bloodgroup;
		this.UserName=UserName;
		this.password = password;
		this.roles = roles;
	}
	
	
	
	/**
	 * @return the doId
	 */
	public int getDoId() {
		return DoId;
	}
	/**
	 * @param doId the doId to set
	 */
	public void setDoId(int doId) {
		DoId = doId;
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
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	
	
	
	
	//Getters and Setters
	
	public String getUserName() {
		return UserName;
	}



	public void setUserName(String userName) {
		UserName = userName;
	}



	public String getRoles() {
		return roles;
	}



	public void setRoles(String roles) {
		this.roles = roles;
	}


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<BloodDonation> getBloodDonation() {
		return bloodDonation;
	}



	public void setBloodDonation(List<BloodDonation> bloodDonation) {
		this.bloodDonation = bloodDonation;
	}




	@OneToMany(targetEntity=BloodDonation.class, cascade = CascadeType.ALL )
	@JoinColumn(name="DonnorBlood_fk", referencedColumnName="DoId")
	private List<BloodDonation> bloodDonation;
	

	
}
