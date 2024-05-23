package com.example.test.controllers;

import java.security.Principal;
import java.util.Optional;

import javax.security.auth.Subject;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.models.AuthCred;
import com.example.test.models.Blog;
import com.example.test.repositories.AuthCredRepository;
import com.example.test.repositories.BlogRepository;

@RestController
@RequestMapping("/admin")
public class BlogController {
	
	@Autowired
	private BlogRepository blogRepository;
	private AuthCredRepository authCredRepository;
	
	
	@PostMapping("/blog")
    @PreAuthorize("hasAuthority('ADMIN')")
	public String saveAuth(@RequestBody Blog blog, Principal principal, Long id) {
		
		org.springframework.security.core.Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
AuthCred  auth = (AuthCred) authenticate.getPrincipal();

//Long userid = auth.getId();
blog.setAuthCred(auth);

		blogRepository.save(blog);
		 return "You Just Blogged!";
	}
	
//	 private Long getLoggedInUserId(Principal principal, Long id) {
//     AuthCred ID = getdeviceId(id).get();
//	return id;
//		 
//	 }

//	private Optional<AuthCred> getdeviceId(Long id) {
//		return authCredRepository.findById(id) ;
//	}
}
