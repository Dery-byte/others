package com.example.RoleBasedAuthorization.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoleBasedAuthorization.entity.BloodDonate;
import com.example.RoleBasedAuthorization.service.BloodDonateService;

@RestController
@RequestMapping("/donate")
public class BloodDonateController {

	@Autowired
	private BloodDonateService bloodDonateService;
	
	@PostMapping("/blood")
	@PreAuthorize("hasAuthority('DONNOR')")
	public String donnateBlood(@RequestBody BloodDonate donnate, Principal principal) {
		bloodDonateService.DonateBlood(donnate, principal);
		return principal.getName() +  " You have successfully requested to donate blood, status is PENDING at the moment";
	
	}
	
	@PostMapping("/approval/{donnorId}/{stockId}")
	@PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public String aproveDonation(@PathVariable int donnorId, @PathVariable int stockId, Principal principal) {
		bloodDonateService.approvedBloodDonationRequest(donnorId, stockId);
		return principal.getName() + " You have approved the donation request "  ;
	
	}
	
	
	//METHODS TO REJECT BLOOD REQUEST
		@GetMapping("/rejectBloodDoantionRequest/{donnorId}")
	    @PreAuthorize("hasAuthority('LABTECHNICIAN')")
		public String rejectBloodRequest(@PathVariable int donnorId, Principal principal) {
			// NB: If a value returns optional and you need to get a variable out of it append dot get to it. (.get())
			bloodDonateService.rejectedBloodDonationRequest(donnorId);
			return  principal.getName() + " you have declined the donation request";
		}
}
