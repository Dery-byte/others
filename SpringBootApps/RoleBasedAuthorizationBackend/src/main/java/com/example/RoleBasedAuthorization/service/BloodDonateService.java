package com.example.RoleBasedAuthorization.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.RoleBasedAuthorization.entity.BloodDonate;
import com.example.RoleBasedAuthorization.entity.BloodRequest;
import com.example.RoleBasedAuthorization.entity.BloodRequestStatus;
import com.example.RoleBasedAuthorization.entity.BloodStock;
import com.example.RoleBasedAuthorization.repository.BloodDonateRepository;
import com.example.RoleBasedAuthorization.repository.BloodStockRepository;

@Service
public class BloodDonateService {

	
	@Autowired
	private BloodDonateRepository boodDonateRepository;
	
	@Autowired 
	private BloodStockRepository bloodStockRepository;
	
	
// Request Doanate
	public BloodDonate DonateBlood(@RequestBody BloodDonate donate, Principal principal) {
		donate.setStatus(BloodRequestStatus.PENDING);
		donate.setDonnorName(principal.getName());
		java.util.Date requestDate = null;
		donate.setRequestDate(requestDate);
		
		return boodDonateRepository.save(donate);	
			
	}
	
	// aprove donate
	public BloodDonate approvedBloodDonationRequest(@PathVariable int donnorId ,int stockId) {
		// NB: If a value returns optional and you need to get a variable out of it append dot get to it. (.get())
		BloodStock stock = bloodStockRepository.findById(stockId).get();
		// Check if the stock availabe is less and more is requested send a mesaage less stock is avilabe can't to process reuest.
		
		BloodDonate DonateID = boodDonateRepository.findById(donnorId).get();
		  int sum= stock.getUnitAvailable() + DonateID.getUnits();
		  
		  //Adds the approval date to the table
		  DonateID.setApprovedDate(new java.util.Date());
			 stock.setUnitAvailable(sum);
			 DonateID.setStatus(BloodRequestStatus.APPROVED);
			return  boodDonateRepository.save(DonateID);
	
}
	
	public BloodDonate rejectedBloodDonationRequest(@PathVariable int donnorId) {
		// NB: If a value returns optional and you need to get a variable out of it append dot get to it. (.get())
		BloodDonate DonateRejected = boodDonateRepository.findById(donnorId).get();
		DonateRejected.setStatus(BloodRequestStatus.REJECTED);
		return boodDonateRepository.save(DonateRejected);
}
}
