package com.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//finder method for signin
	Optional<Employee> findByEmailAndPassword(String em, String pass);

	// derived finder method : date n dept
	List<Employee> findByJoinDateAfterAndDepartment(LocalDate date, String deptName);

	// custom query method : for getting complete name by sal
	@Query(value = "select new com.app.pojos.Employee(firstName,lastName) from Employee e where e.salary between ?1 and ?2")
	// List<Employee> fetchEmpNamesBySalaryRange(double minSalary,double maxSalary);
	Stream<Employee> fetchEmpNamesBySalaryRange(double minSalary, double maxSalary);
		
	//method Find all emps having lastname containing some keyword
	@Query("select e from Employee e where e.lastName like %?1%")
	List<Employee> fetchAllEmployeeContainingString(String keyword);
	
	List<Employee> findByLastNameContaining(String keyword);
	
	List<Employee> findByDepartmentAndJoinDateIsBefore(String deptName,LocalDate beforeDate);
}
