package com.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojo.Employee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class TestEmployeeRepository {
	@Autowired
	private EmployeeRepository empRepo;

	@Test
	void test() {
		assertNotNull(empRepo);
	}

	@Test
	void testAddEmployee() {
		List<Employee> emp = List.of(
				new Employee("Shubham", "Gudekar", "shubham@gmail.com", "shubham", "Pune", "HR",
						LocalDate.parse("2023-03-03"), 50000),
				new Employee("Sagar", "Satav", "sagar@gmail.com", "sagar", "Pune", "RND", LocalDate.parse("2023-03-03"),
						50000),
				new Employee("Ram", "Manjare", "ram@gmail.com", "ram", "Pune", "Development",
						LocalDate.parse("2023-03-03"), 50000));

		List<Employee> savedEmps = empRepo.saveAll(emp);
		
		assertEquals(3, savedEmps.size());

	}

}
