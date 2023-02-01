package com.app.dao;

import java.util.List;

import com.app.pojo.Employee;

public interface EmployeeDao {
	
	
	//method to get all employee in a department
	List<Employee> getAllEmployee(String deptName);
	
	//method to delete employee
	String deleteEmployee(Long empId);
}
