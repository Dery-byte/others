package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.UsersInstances;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
@RestController
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctortRepository;
	@PostMapping("/doctor/register")
	public String  Register(@RequestBody Doctor doctor) {
		doctor.setRoles(UsersInstances.DOCTOR);
		doctortRepository.save(doctor);
		return "Hi " + doctor.getUserName() + ", welcome";
	}
	
	
	

}
