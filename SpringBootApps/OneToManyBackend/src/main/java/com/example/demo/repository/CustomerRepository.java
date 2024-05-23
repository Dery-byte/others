package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.OrderResponse;
import com.example.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	@Query("SELECT new com.example.demo.dto.OrderResponse(c.name, p.productName, p.price) FROM Customer c JOIN c.products p")
	public  List<OrderResponse> getJoinInformation();

}
