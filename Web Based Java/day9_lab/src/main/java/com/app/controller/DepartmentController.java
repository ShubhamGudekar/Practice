package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.DepartmentDao;
import com.app.dao.EmployeeDao;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentDao dao;
	@Autowired
	private EmployeeDao employeeDao;

	public DepartmentController() {
		System.out.println("in default constructor" + getClass());
	}

	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}

	@GetMapping("/")
	public String displayForm(Model map) {
		System.out.println("in display from method");
		map.addAttribute("dept_list", dao.getAllDepartment());
		return "/department/form";
	}

	@GetMapping("department/show")
	public String displayEmploye(@RequestParam String deptName, Model map) {
		System.out.println("in show employee method deptid : " + deptName);
		map.addAttribute("emp_list", employeeDao.getAllEmployee(deptName)).addAttribute("dept", deptName);
		return "/department/employees";
	}

}
