package com.example.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.test.models.AuthCred;
import com.example.test.repositories.AuthCredRepository;

@Service
public class MyUserDetailsService  implements UserDetailsService{

	@Autowired
	private AuthCredRepository authCredRepository;
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
Optional<AuthCred> auth = authCredRepository.findByUserName(s);

      
        auth.orElseThrow(()-> new UsernameNotFoundException (s + " Not found") );

		return auth.map(MyUserDetails::new).get();
				
				
	}

}
