package com.example.RoleBasedAuthorization.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.RoleBasedAuthorization.entity.BloodStock;
import com.example.RoleBasedAuthorization.repository.BloodStockRepository;

@Service
public class BloodStockService {
	
	@Autowired
	private BloodStockRepository bloodStockRepository;
	
	public BloodStock addStock(@RequestBody BloodStock bloodstock, Principal principal) {
		bloodstock.setLabtechnicianName(principal.getName());
		return bloodStockRepository.save(bloodstock);
	}
	
	public Optional<BloodStock> updateStock(@PathVariable  int stockId) {
	 Optional<BloodStock> bloodStockId = bloodStockRepository.findById(stockId);
	return bloodStockId;
	}
	
	public List<BloodStock> viewStock(){
		return bloodStockRepository.findAll();
		
	}
	//get stock by bloodgroup. (make sure the field to get the data by is always at the end of your method in the repository)
	public BloodStock getBloodGroupByName(@PathVariable String bloodgroup){
		return bloodStockRepository.findStockBybloodgroup(bloodgroup);		
	}
	
	// Returns all the stock unitavailable
//	 public BloodStock totalStock() {
//		 bloodStockRepository.findAll().
//		 stream().forEach(BloodStock-> {
//			 BloodStock.getUnitAvailable();
//			});
//		 
//		 return BloodStock;
//		} 
	
	

}
