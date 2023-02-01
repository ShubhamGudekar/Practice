package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.Department;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Department> getAllDepartment() {
		System.out.println("in deptdao "+entityManager);
		String jpql = "select d from Department d";
		return entityManager.createQuery(jpql, Department.class).getResultList();
	}

}
