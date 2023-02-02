package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Employee;
import com.app.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in default constructor "+getClass());
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		System.out.println("in getallEmployee method"+getClass());
		return empService.getAllEmployee();
	}
	
	@PostMapping
	public String addEmployee(@RequestBody Employee newEmployee) {
		System.out.println("in add new Employee" + getClass());
		if(empService.insertEmployeeDetails(newEmployee)!=null)
			return "Employee Added Successfull";
		return "Employee Not Added";
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmployee(@PathVariable Long empId) {
		empService.deleteEmployee(empId);
	}
	
	@GetMapping("/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable Long empId) {
		return empService.getEmployeeById(empId);
	}
	
	
	@PutMapping()
	public void updateEmployee(@RequestBody Employee updateEmployee) {
		empService.insertEmployeeDetails(updateEmployee);
	}
	
	
}
