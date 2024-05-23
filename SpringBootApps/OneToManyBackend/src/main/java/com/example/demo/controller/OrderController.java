package com.example.demo.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;

import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.OrderResponse;

@RestController
public class OrderController {
    @Autowired
	private CustomerRepository customerRepository;
    
   // @Autowired
	//private ProductRepository productRepository;
    
    @PostMapping("/placeOrder")
    public Customer PlaceOrder(@RequestBody OrderRequest request) {
    	
    	return customerRepository.save(request.getCustomer());
    }
    
 
    
    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
    	return customerRepository.findAll();
    }
    
    @GetMapping("/getJoinInfo")
    public List<OrderResponse> getJoinInformation(){
    	return customerRepository.getJoinInformation();
    }
}
