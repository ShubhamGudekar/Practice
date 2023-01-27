package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AdmissionDaoImpl;
import pojos.Student;

public class StudentCourseRegistration {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Hibernate up n running !" + sf);
			AdmissionDaoImpl admissionDaoImpl=new AdmissionDaoImpl();
			System.out.println("Enter Details of Course ");
			Long cId=sc.nextLong();
			sc.nextLine();
			
			System.out.println("Enter Students firstName lastName email");
			Student student=new Student(sc.next(), sc.next(), sc.next());
			System.out.println(admissionDaoImpl.studentCourseRegistration(cId, student));
		} // JVM : sf.close() => DB cn pool is cleaned up...
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
