package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployee(String deptName) {
		String jpql = "select e from Employee e where e.department.name=:dept";
		return entityManager.createQuery(jpql, Employee.class).setParameter("dept", deptName).getResultList();
	}

	@Override
	public String deleteEmployee(Long empId) {
		String msg = "Deleting Employee with EmpId : " + empId;
		Employee emp = entityManager.find(Employee.class, empId);
		if (emp != null) {
			entityManager.remove(emp);
			return msg + "Successfull";
		}
		return msg + "Failed";
	}

}
