package com.example.RoleBasedAuthorization.service;

import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.RoleBasedAuthorization.entity.BloodRequest;
import com.example.RoleBasedAuthorization.entity.BloodRequestStatus;
import com.example.RoleBasedAuthorization.entity.BloodStock;
import com.example.RoleBasedAuthorization.entity.Users;
import com.example.RoleBasedAuthorization.repository.BloodRequestRepository;
import com.example.RoleBasedAuthorization.repository.BloodStockRepository;
import com.example.RoleBasedAuthorization.repository.UsersRepository;

@Service
public class BloodRequestService {
	private static final Integer stockId = null;

	@Autowired
	private BloodRequestRepository postRepository;
	
	@Autowired 
private BloodStockRepository bloodStockRepository;

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private BloodRequestRepository bloodReuestRepository;
	
	

	public BloodRequest doctorBloodRequest(@RequestBody BloodRequest post, Principal principal) {
	
	 //BloodStock stock = bloodStockRepository.findById(stockId).get();
	 
//	if(stock.getUnitAvailable()> post.getUnits()) {
		post.setStatus(BloodRequestStatus.PENDING);
		post.setDoctorName(principal.getName());
		java.util.Date requestDate = null;
		post.setRequestDate(requestDate);
		return postRepository.save(post);	
//	}
//	return "Less stock availabe";
//			
		 
		
	}
	
	public BloodRequest approvedBloodRequest(@PathVariable int RquestId ,int stockId) {
		// NB: If a value returns optional and you need to get a variable out of it append dot get to it. (.get())
		BloodStock stock = bloodStockRepository.findById(stockId).get();
		// Check if the stock availabe is less and more is requested send a mesaage less stock is avilabe can't to process reuest.
		
		BloodRequest post = postRepository.findById(RquestId).get();
		  int deff= stock.getUnitAvailable() -post.getUnits();
		  
		  //Adds the approval date to the table
			 post.setApprovedDate(new java.util.Date());
			 stock.setUnitAvailable(deff);
			 post.setStatus(BloodRequestStatus.APPROVED);
			return  postRepository.save(post);   

	}
	
	public void approveAll() {
		postRepository.findAll().stream().filter(post->post.getStatus().equals(BloodRequestStatus.PENDING)).forEach(post->{
			post.setStatus(BloodRequestStatus.APPROVED);
			postRepository.save(post);
		});
		
	}
	
	public BloodRequest rejectedBloodRequest(@PathVariable int RquestId) {
		// NB: If a value returns optional and you need to get a variable out of it append dot get to it. (.get())
		BloodRequest post = postRepository.findById(RquestId).get();
		post.setStatus(BloodRequestStatus.REJECTED);
		return postRepository.save(post);
}
	//Reject Request
	public void rejectedAll() {
		postRepository.findAll().stream().filter(post->post.getStatus().equals(BloodRequestStatus.PENDING)).forEach(post->{
			post.setStatus(BloodRequestStatus.REJECTED);
			postRepository.save(post);
		});
	
	}
	
	//Get only approved request
	public List<BloodRequest> viewedAll(){
		return postRepository.findAll().stream().filter(post->post.getStatus().equals(BloodRequestStatus.APPROVED)).collect(Collectors.toList());
		}
	
	
	
	//Get only approved request
		public List<BloodRequest> viewedAllRejected(){
			return postRepository.findAll().stream().filter(post->post.getStatus().equals(BloodRequestStatus.REJECTED)).collect(Collectors.toList());
			}
		
	// Get all the request
	public List<BloodRequest> findAllRequest() {
		return bloodReuestRepository.findAll();
		
	}

	
	// REquest to donnate blood
	public BloodRequest BloodDanationRequest(@RequestBody BloodRequest post, Principal principal) {
		
		 //BloodStock stock = bloodStockRepository.findById(stockId).get();
		 
//		if(stock.getUnitAvailable()> post.getUnits()) {
			post.setStatus(BloodRequestStatus.PENDING);
			post.setDoctorName(principal.getName());
			java.util.Date requestDate = null;
			post.setRequestDate(requestDate);
			return postRepository.save(post);	
//		}
//		return "Less stock availabe";
//				
			 
			
		}
	
	
	
	
	
	
	
	
	
	
}
