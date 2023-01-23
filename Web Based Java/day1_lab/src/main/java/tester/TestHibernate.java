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
			System.out.println("Enter emp details : firstName,  lastName,  " 
			+ "dept,  salary,  dob isPermanent");
			// create transient emp
			Employee emp = new Employee(sc.next(), sc.next(), 
					Department.valueOf(sc.next().toUpperCase()),
					sc.nextDouble(), LocalDate.parse(sc.next()),
					sc.nextBoolean());
			//invoke dao's method
			System.out.println(empDao.addEmpDetails(emp));
			} //JVM :sc.close() => Scanner Closed sf.close() => DB cn pool is cleaned up...
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
