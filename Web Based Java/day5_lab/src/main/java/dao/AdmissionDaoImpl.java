package dao;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Admission;
import pojos.AdmissionStatus;
import pojos.Course;
import pojos.Student;
import utils.HibernateUtils;

public class AdmissionDaoImpl implements AdmissionDao {

	@Override
	public String studentCourseRegistration(Long courseId, Student studentDetails) {
		String msg = "Student Admission Failed";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.persist(studentDetails); //first inserting student into student table
			Course course = session.get(Course.class, courseId); //retrieving course from courseid
			Admission admission = new Admission(); //creating an instance of new admission

			if (course != null) { 
				admission.setStatus(AdmissionStatus.APPLIED); //setting default to applied
				admission.setResultDate(LocalDate.now().plusDays(15)); //set result date to + 15 from current date
				
				
				course.addAdmission(admission); // linking addmission to course
				studentDetails.addAdmission(admission); // linking addmission to student
			}

			else
				msg = "Course not Found for CourseID " + courseId;
			transaction.commit();
			msg = "Student Admission Successfull Admission Id : " + admission.getId();
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
		return msg;
	}

}
