package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
