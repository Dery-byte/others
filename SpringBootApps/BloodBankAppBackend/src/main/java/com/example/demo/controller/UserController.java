package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.UsersInstances;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@RestController

public class UserController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@PostMapping("/user/register")
	public String  Register(@RequestBody Users users) {
		 users.setRoles(UsersInstances.DOCTOR);
		 usersRepository.save(users);
		return "Hi " + users.getName() + ", welcome as " + users.getRoles() ;
	}
	

}
