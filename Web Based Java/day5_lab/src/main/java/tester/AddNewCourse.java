package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;

public class AddNewCourse {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Hibernate up n running !" + sf);
			CourseDaoImpl cDao = new CourseDaoImpl();

			System.out.println("Enter Details of Course ");
			System.out.println("Enter Title StartDate(YYYY-MM-DD) EndDate(YYYY-MM-DD) Fees Capacity");

			System.out.println(cDao.registerCourse(sc.next(), LocalDate.parse(sc.next()), LocalDate.parse(sc.next()),
					sc.nextDouble(), sc.nextInt()));
		} // JVM : sf.close() => DB cn pool is cleaned up...
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
