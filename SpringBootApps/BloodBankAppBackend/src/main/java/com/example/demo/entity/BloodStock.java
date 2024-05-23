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
public class BloodStock {
	@Id
	@GeneratedValue
	private int stockId;
	private int unitAvailable;
	private BloodGroup bloodgroup;
	
	
	// Constructor
	
	
	

	public BloodStock(int unitAvailable, BloodGroup bloodgroup) {
		super();
		this.unitAvailable = unitAvailable;
		this.bloodgroup = bloodgroup;
	}
	
	
	
	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}
	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	/**
	 * @return the unitAvailable
	 */
	public int getUnitAvailable() {
		return unitAvailable;
	}
	/**
	 * @param unitAvailable the unitAvailable to set
	 */
	public void setUnitAvailable(int unitAvailable) {
		this.unitAvailable = unitAvailable;
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
	
	
}
