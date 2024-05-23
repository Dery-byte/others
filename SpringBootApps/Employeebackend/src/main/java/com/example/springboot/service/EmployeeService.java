package com.example.springboot.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}
	
	public Optional<Employee> updateEmployees(Long id) {
		return employeeRepository.findById(id);
	}

public void deleteById(@PathVariable Long id) {
	 employeeRepository.deleteById(id);
    }
}


	
	
	
	
	
