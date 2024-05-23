package com.example.RoleBasedAuthorization.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RoleBasedAuthorization.entity.BloodStock;
import com.example.RoleBasedAuthorization.service.BloodStockService;

@RestController
@RequestMapping("/stock")
public class BloodStockController {

	@Autowired
	private BloodStockService bloodStockService;
	
	
	@PostMapping("/add")
	@PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public String addStock(@RequestBody BloodStock stocks, Principal principal) {
		bloodStockService.addStock(stocks, principal);
		
		return principal.getName() +" You have Succesfully stocked blood";
	}
	
//Update the Stock by Blood Group Id API
	@PutMapping("/update/{stockId}")
	@PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public String updateStock(@PathVariable int stockId , @RequestBody BloodStock bloodStock, Principal principal) {
		BloodStock stocks = bloodStockService.updateStock(stockId).orElseThrow();
		int updateVal = stocks.getUnitAvailable() + bloodStock.getUnitAvailable();
		stocks.setBloodgroup(bloodStock.getBloodgroup());
		stocks.setLabtechnicianName(principal.getName());
		stocks.setUnitAvailable(updateVal);
		bloodStockService.addStock(bloodStock, principal);
		return " You have successfully updated the blood stock";
	}
	
	//View Stock
	
	@GetMapping("/viewStocks/")
	@PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public List<BloodStock> viewAvailableStock() {
		return bloodStockService.viewStock();
	}
	
	
	//Update Stock By Blood Group Name API
	
	@PutMapping("/updateByBloodGroup/{bloodgroup}")
	@PreAuthorize("hasAuthority('LABTECHNICIAN')")
	public String updateStockByBloodGroup(@PathVariable String bloodgroup, @RequestBody BloodStock bloodStock, Principal principal) {
		BloodStock StockName =bloodStockService.getBloodGroupByName(bloodgroup);
		int updateValue = StockName.getUnitAvailable() + bloodStock.getUnitAvailable();
		//StockName.setBloodgroup(bloodStock.getBloodgroup());
		StockName.setLabtechnicianName(principal.getName());
		StockName.setUnitAvailable(updateValue);
		bloodStockService.addStock(bloodStock, principal);
		return " Blood Group " + StockName.getBloodgroup() + " has been updated to " + StockName.getUnitAvailable() +"mls ";
		
	}
	
//	@GetMapping("/total")
//	@PreAuthorize("hasAuthority('LABTECHNICIAN')")
//   public String totalStocks() {
//		BloodStock stocks =bloodStockService.totalStock();
//		
//		return "You ";
//	} 
	
	
	
	
}
