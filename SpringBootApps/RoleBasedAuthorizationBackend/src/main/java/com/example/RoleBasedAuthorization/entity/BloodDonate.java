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
@Table(name="BloodDonate")
public class BloodDonate {
	
	    @Id
		@GeneratedValue
		private int donnorId;
		private String donnorName; // this will map a donnor to blood donate
		private int age;
		private String disease;
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
		
		@PrePersist()
		private void onCreate() {
			requestDate = new Date();
			approvedDate = new Date(00000000000000);
	}

		
		
		
		// Getters and setters
		
		public int getDonnorId() {
			return donnorId;
		}
		public void setDonnorId(int donnorId) {
			this.donnorId = donnorId;
		}
		public String getDonnorName() {
			return donnorName;
		}
		public void setDonnorName(String donnorName) {
			this.donnorName = donnorName;
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
		public Date getRequestDate() {
			return requestDate;
		}
		public void setRequestDate(Date requestDate) {
			this.requestDate = requestDate;
		}
		public Date getApprovedDate() {
			return approvedDate;
		}
		public void setApprovedDate(Date approvedDate) {
			this.approvedDate = approvedDate;
		}
		public String getBloodgroup() {
			return bloodgroup;
		}
		public void setBloodgroup(String bloodgroup) {
			this.bloodgroup = bloodgroup;
		}
		
		
		
		
		
}
