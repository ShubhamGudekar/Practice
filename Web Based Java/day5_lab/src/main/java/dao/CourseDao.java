package dao;

import java.time.LocalDate;

public interface CourseDao {

	String registerCourse(String title, LocalDate startDate, LocalDate endDate, double fees, int capacity);
	
}
