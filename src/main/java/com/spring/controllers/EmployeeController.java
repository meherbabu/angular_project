package com.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.repository.EmployeeRepository;
import com.spring.vo.Employee;

@RestController
@RequestMapping("/home")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepository;

	@RequestMapping(method = RequestMethod.GET)	
	public Employee getEmployees() {
		return empRepository.getData();
	}
}
