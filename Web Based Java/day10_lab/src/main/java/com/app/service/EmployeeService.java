package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojo.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee insertEmployeeDetails(Employee newEmployee);

	void deleteEmployee(Long empId);

	Optional<Employee> getEmployeeById(Long empId);

	
}
