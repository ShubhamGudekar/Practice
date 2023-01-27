package dao;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import utils.HibernateUtils;

public class CourseDaoImpl implements CourseDao {

	@Override
	public String registerCourse(String title, LocalDate startDate, LocalDate endDate, double fees, int capacity) {
		String msg = "Course Not Registered";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Course course = new Course(title, startDate, endDate, fees, capacity);
			session.persist(course);
			msg = "Course Resgistration Successfull Course Id : " + course.getId();
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
		return msg;
	}

}
