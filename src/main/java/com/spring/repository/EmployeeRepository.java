package com.spring.repository;

import org.springframework.stereotype.Repository;

import com.spring.vo.Employee;

@Repository
public class EmployeeRepository {
	public Employee getData() {
		return new Employee("meher");
	}
}
