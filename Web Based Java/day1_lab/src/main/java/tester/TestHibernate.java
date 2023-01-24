package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import dao.EmployeeDaoImpl;
import pojo.Department;
import pojo.Employee;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create emp dao instance
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
//			System.out.println("Enter emp details : firstName,  lastName,  " 
//			+ "dept,  salary,  dob isPermanent");
//			// create transient emp
//			Employee emp = new Employee(sc.next(), sc.next(), 
//					Department.valueOf(sc.next().toUpperCase()),
//					sc.nextDouble(), LocalDate.parse(sc.next()),
//					sc.nextBoolean());
//			//invoke dao's method
//			System.out.println(empDao.addEmpDetails(emp));

//			3.1 List all employees from specific dept earning salary > specific salary
//			System.out.println("Enter dept and salary");
//			empDao.getAllEmpWithSalGtThan(Department.valueOf(sc.next().toUpperCase()), sc.nextDouble())
//			.forEach(System.out::println);

//			3.2 List emp id , first name , last name , salary for all permanent emps
//			empDao.getAllPermanentEmployee().forEach(e -> System.out.println("EmpId : " + e.getId() + " First Name : "
//					+ e.getFirstName() + " LastName : " + e.getLastName() + " Salary : " + e.getSalary()));

//			3.3 Transfer emp to a new department n salary raise, having specified first name n last name
//			System.out.println("Enter firstName lastname newDept salaryRaise");
//			System.out.println(
//					empDao.transferEmployee(sc.next(), sc.next(), Department.valueOf(sc.next().toUpperCase()),sc.nextDouble()));

//			3.4 Delete all temporary employees
			System.out.println(empDao.deleteTemporaryEmployee());
			
		} // JVM :sc.close() => Scanner Closed sf.close() => DB cn pool is cleaned up...
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
