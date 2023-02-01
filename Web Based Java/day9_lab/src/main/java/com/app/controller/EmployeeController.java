package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.EmployeeDao;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao empDao;

	public EmployeeController() {
		System.out.println("in default constructor" + getClass());
	}

	@GetMapping("/delete/{empid}")
	public String deleteEmployee(@PathVariable Long empid) {
		System.out.println("Emp Id = "+empid);
		System.out.println(empDao.deleteEmployee(empid));
		return "redirect:/";
	}
	
	@GetMapping("/update/{empid}")
	public String updateEmployee(@PathVariable Long empid) {
		System.out.println("Emp Id = "+empid);
		
		return null;
	}

}
