package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.UsersInstances;
import com.example.demo.entity.BloodGroup;
import com.example.demo.entity.Donnor;
import com.example.demo.repository.DonnorRepository;

@RestController
public class DonnorController {
	
	
	@Autowired
	private DonnorRepository donnorRepository;
	
	@PostMapping("/donnor/register")
	public String  Register(@RequestBody Donnor donnor) {
		donnor.setRoles(UsersInstances.DONOR);
		donnor.setBloodgroup(BloodGroup.AB);
		donnorRepository.save(donnor);
		return "Hi " + donnor.getUserName() + ", welcome to the app as a Donnor";
	}
}
