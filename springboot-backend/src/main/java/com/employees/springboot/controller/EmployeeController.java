package com.employees.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.springboot.model.Employee;
import com.employees.springboot.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/coins")
	private List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	@PostMapping("/coin")
	private Employee createEmployee(@RequestBody Employee employee) {		
		Optional<Employee> matchingObject = employeeRepository.findAll().stream().
			    filter(e -> e.getName().equals(employee.getName())).
			    findFirst();
		if(matchingObject.isPresent()) {
			Employee existingEmployee = matchingObject.get();
			existingEmployee.setCoins(existingEmployee.getCoins() + employee.getCoins() );
			return employeeRepository.save(existingEmployee);
		}
		return employeeRepository.save(employee);
	}
	
	

}
