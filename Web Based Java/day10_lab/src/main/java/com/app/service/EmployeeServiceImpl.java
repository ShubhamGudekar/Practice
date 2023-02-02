package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		System.out.println("in getallEmployee method" + getClass());
		return empRepo.findAll();
	}

	@Override
	public Employee insertEmployeeDetails(Employee newEmployee) {
		return empRepo.save(newEmployee);
	}

	@Override
	public void deleteEmployee(Long empId) {
		if (empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
		}
	}

	@Override
	public Optional<Employee> getEmployeeById(Long empId) {
		return empRepo.findById(empId);
	}
	
	

}
