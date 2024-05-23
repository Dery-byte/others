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
public class LabTech {
	@Id
	@GeneratedValue
	private int LabId;
	private String FirstName;
	private String userName;
	private String roles;
	private String password;
	
	//Constructor
	public LabTech(int labId, String firstName, String userName, String roles,String password) {
		super();
		this.LabId = labId;
		this.FirstName = firstName;
		this.userName = userName;
		this.roles = roles;
		this.password=password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	//Getters and Setters
	public int getLabId() {
		return LabId;
	}
	public void setLabId(int labId) {
		LabId = labId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
