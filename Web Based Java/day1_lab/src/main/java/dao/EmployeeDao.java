package dao;

import java.util.List;

import pojo.Department;
import pojo.Employee;

public interface EmployeeDao {
//add a method to emp details
	String addEmpDetails(Employee newEmp);
	
	//list all employe from specific dept earning salary > specific salary
	List<Employee> getAllEmpWithSalGtThan(Department dept,double salary);
	
	//3.2 List emp id , first name , last name , salary for all permanent emps
	List<Employee> getAllPermanentEmployee();
	
//	3.3 Transfer emp to a new department n salary raise, having specified first name n last name
	String transferEmployee(String firstName,String lastName,Department newDept,double salaryRaise);
	
//	3.4 Delete all temporary employees
	String deleteTemporaryEmployee();
}
