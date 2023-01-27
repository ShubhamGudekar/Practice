package dao;

import pojos.Student;

public interface AdmissionDao {
	
	public String studentCourseRegistration(Long courseId,Student studentDetails);
}
