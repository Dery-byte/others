package com.example.blogApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogApp.dto.LoginRequest;
import com.example.blogApp.dto.RegisterRequest;
import com.example.blogApp.service.AuthService;

@RestController

@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public String signUp(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return "Successfully signed up";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) { 
		return authService.login(loginRequest);
		
	}

}
