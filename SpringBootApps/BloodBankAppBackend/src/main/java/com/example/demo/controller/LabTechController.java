package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.UsersInstances;
import com.example.demo.entity.LabTech;
import com.example.demo.repository.LabTechRepository;

@RestController
public class LabTechController {
	@Autowired
	private LabTechRepository labTechRepository;
	@PostMapping("/labtech/register")
	public String  Register(@RequestBody LabTech labTech) {
		labTech.setRoles(UsersInstances.LABTECHNICIAN);
		labTechRepository.save(labTech);
		return "Hi " + labTech.getFirstName() + ", welcome as the Admin";
	}
}
