package com.example.RoleBasedAuthorization.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoleBasedAuthorization.entity.BloodRequest;
import com.example.RoleBasedAuthorization.entity.Users;
import com.example.RoleBasedAuthorization.service.BloodRequestService;


@RestController
@RequestMapping("/request")
public class BloodRequestController {
	@Autowired
	private BloodRequestService bloodRequestService;
	
	
	
	@PostMapping("/blood")
	@PreAuthorize("hasAuthority('DOCTOR')")
	public String requestBlood(@RequestBody BloodRequest post, Principal principal) {
		bloodRequestService.doctorBloodRequest(post, principal);
		return principal.getName() +  " You have successfully requested for blood status is PENDING at the moment";
		
	}
	
	
	
	//METHOD TO APPROVE A single BLOOD REQUEST at a time 
	@GetMapping("/approveBloodRequest/{RquestId}/{stockId}")
    @PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public String approveBloodRequest(@PathVariable int RquestId, @PathVariable int stockId) {
		// NB: If a value returns optional and you need to get a variable out of it append dot get to it. (.get())
		bloodRequestService.approvedBloodRequest(RquestId, stockId);
		return "Blood Request Approved";
	}
	
	//METHOD TO APPROVE BULK REQUEST.
	@GetMapping("/approveAllRequest")
    @PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public String approveAll() {
		bloodRequestService.approveAll();
		return " You have approved all Pending Blood Request";
	}
	
	//METHODS TO REJECT BLOOD REQUEST
	@GetMapping("/rejectBloodRequest/{postId}")
    @PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public String rejectBloodRequest(@PathVariable int postId) {
		// NB: If a value returns optional and you need to get a variable out of it append dot get to it. (.get())
		bloodRequestService.rejectedBloodRequest(postId);
		return "Request Rejected";
	}
	
	//METHOD TO REJECT BULK POSTS.
		@GetMapping("/rejectAllRequest")
	    @PreAuthorize("hasAuthority('LABTECHNICIAN')")
		public String rejecteAll() {
			bloodRequestService.rejectedAll();
			return " You have rejected all Pending Blood Request";
		}
		
		//RETURN ONLY ALL APPROVED POST
		@GetMapping("/viewAllApprovedRequest")
		@PreAuthorize("hasAuthority('LABTECHNICIAN')")
		public List<BloodRequest> viewAll(){
		return bloodRequestService.viewedAll();
		}
		
		//RETURN ONLY ALL APPROVED POST
				@GetMapping("/viewAllRejectedRequest")
				@PreAuthorize("hasAuthority('LABTECHNICIAN')")
				public List<BloodRequest> viewAllRejected(){
        return bloodRequestService.viewedAllRejected();
				}
		
		
		// Get all the 
		@GetMapping("/viewAllRequest")
	    @Secured("LABTECHNICIAN")
	    @PreAuthorize("hasAuthority('LABTECHNICIAN')")
		public List<BloodRequest> viewAllRequest(){
			return bloodRequestService.findAllRequest();
	    }

		//Blood Donation Request
		@PostMapping("/Toblood")
		@PreAuthorize("hasAuthority('DONNOR')")
		public String requestToDonate(@RequestBody BloodRequest post, Principal principal) {
			bloodRequestService.BloodDanationRequest(post, principal);
			return principal.getName() +  " You have successfully requested to donate blood, status is PENDING at the moment";
			
		}

}
