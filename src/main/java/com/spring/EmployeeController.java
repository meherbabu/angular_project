package com.rest.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.Employee;
import com.rest.dao.EmpRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Inject
	private EmpRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return repo.getEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable String id) {
		Employee emp = getRepo().geEmployee(id);

		if (emp == null) {
			throw new NoEmpFoundException(id);
		}
		return emp;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Employee emp) {
		System.out.println(emp.getId() + "  " + emp.getName());
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Employee emp) {
		System.out.println(emp.getId() + "  " + emp.getName());
	}

	@ExceptionHandler(NoEmpFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handleException(NoEmpFoundException e) {
		return new Error(e.getId());
	}

	public EmpRepository getRepo() {
		return repo;
	}

	public void setRepo(EmpRepository repo) {
		this.repo = repo;
	}

}
