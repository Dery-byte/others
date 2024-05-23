package com.example.blogApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.blogApp.dto.LoginRequest;
import com.example.blogApp.dto.RegisterRequest;
import com.example.blogApp.model.Users;
import com.example.blogApp.repository.UsersRepository;
import com.example.blogApp.security.JwtProvider;


@Service
public class AuthService { 
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	
	public void signup(RegisterRequest registerRequest) {
	Users users = new Users();
	users.setUserName(registerRequest.getUserName());
	users.setPassword(encodePassword(registerRequest.getPassword()));
	users.setEmail(registerRequest.getEmail());
	usersRepository.save(users);
	
	}
	public String login(LoginRequest loginRequest) {
		Authentication authenticate =authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken( loginRequest.getUserName(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return jwtProvider.generateToken(authenticate);
	}
	
	
	
	
	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}
	public Optional<User> getCurrentUser() {
 User principal =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
		return Optional.of(principal);
	}
}
