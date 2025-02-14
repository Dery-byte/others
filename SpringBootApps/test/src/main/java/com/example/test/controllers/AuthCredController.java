package com.example.test.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.common.UserInstances;
import com.example.test.models.AuthCred;
import com.example.test.repositories.AuthCredRepository;

@RestController
@RequestMapping("/user")
public class AuthCredController {
	

	@Autowired
	private AuthCredRepository authCredRepository;
	
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	//private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/join/Admin")
	public String saveAuth(@RequestBody AuthCred authCred) {
		//String enCreptedpwd =  passwordEncoder.encode(authCred.getPassword());
		//authCred.setPassword(enCreptedpwd);
		authCred.setRole(UserInstances.ADMIN_USER);
		String enpwd = passwordEncoder.encode(authCred.getPassword());
		authCred.setPassword(enpwd);
		 authCredRepository.save(authCred);
		 return "Welcome to the admin!";
	}
	
	@PostMapping("/join")
	public String saveUser(@RequestBody AuthCred authCred) {
		String enCreptedpwd =  passwordEncoder.encode(authCred.getPassword());
		authCred.setPassword(enCreptedpwd);
		authCred.setRole(UserInstances.OTHER_USERS);
		 authCredRepository.save(authCred);
		 return "Welcome to the user!";
	}
	
	

}
