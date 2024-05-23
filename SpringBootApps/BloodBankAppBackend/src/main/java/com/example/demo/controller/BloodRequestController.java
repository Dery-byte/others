package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BloodRequest;
import com.example.demo.entity.RequestStatus;
import com.example.demo.repository.BloodRequestRepository;

@RestController
@RequestMapping("/request")
public class BloodRequestController {
	
	@Autowired
	private BloodRequestRepository bloodRequestRepository;
	
	@PostMapping("/blood")
    @PreAuthorize("hasAuthority('DOCTOR')")
	public String RequestBlood(@RequestBody BloodRequest bloodrequest ,Principal principal) {
		bloodrequest.setRstatus(RequestStatus.PENDING);
		bloodrequest.setDoctorName(principal.getName());
		bloodRequestRepository.save(bloodrequest);
		return "You have successfully requested for blood status is PENDING at the moment";
		
	}
}
