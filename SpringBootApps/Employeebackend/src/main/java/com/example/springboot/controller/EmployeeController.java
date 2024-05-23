package com.example.springboot.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;
import com.example.springboot.model.Employee;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@Controller
@ResponseBody
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	// get all employees REST API
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	
	//Add  employee Rest API
	@PostMapping(value="/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	// Get single employee ById  Rest API
	/**
	 * @param id
	 * @return
	 */
	@GetMapping(value="/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable Long id) {
		Optional<Employee> employeeSingle =employeeService.getEmployeeById (id);
		return employeeSingle;
	}
	
	 //update Employee Rest API
	@PutMapping("/employees/{id}")
	public Employee updateEmployee( @PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeService.updateEmployees(id).orElseThrow();
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		return employeeService.addEmployee(employee);
	}
	
	
	// Delete Employee API
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id ){
		//Employee employee = employeeService.getEmployeeById(id).orElseThrow();
		employeeService.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
	
	
	}



