package com.example.blogApp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
String jwt =getJwtFromrequest(request);		


if(StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt)) {
	String username= jwtProvider.getUsernameFromJwt(jwt);
	
	UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
			userDetails.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	
	SecurityContextHolder.getContext().setAuthentication(authentication);
	
}
filterChain.doFilter(request, response);
	}
	
	
	
	

	private String  getJwtFromrequest(HttpServletRequest request) {
  String bearerToken = request.getHeader("Authorization");
  if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
	  return bearerToken.substring(7);
  }
  
  return bearerToken;
	}

}
