package com.example.RoleBasedAuthorization.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
//@Table(name="BloodStock", uniqueConstraints={@UniqueConstraint(columnNames = {"bloodgroup"})})

@Table(name="BloodStock")
public class BloodStock {
	
	@Id
	@GeneratedValue
	private int stockId;
	private int unitAvailable;
	private String bloodgroup;
	private String labtechnicianName;	
	
	
	
//	public BloodStock(int stockId, int unitAvailable, String bloodgroup, String labtechnicianName) {
//		super();
//		this.stockId = stockId;
//		this.unitAvailable = unitAvailable;
//		this.bloodgroup = bloodgroup;
//		this.labtechnicianName = labtechnicianName;
//	}

	public String getLabtechnicianName() {
		return labtechnicianName;
	}
	public void setLabtechnicianName(String labtechnicianName) {
		this.labtechnicianName = labtechnicianName;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getUnitAvailable() {
		return unitAvailable;
	}
	public void setUnitAvailable(int unitAvailable) {
		this.unitAvailable = unitAvailable;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	
	
	
	
}
