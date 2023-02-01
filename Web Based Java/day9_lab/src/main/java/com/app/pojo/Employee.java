package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee extends BaseEntity {

	private String name;
	
	private String address;
	
	private double salary;
	
	@Column(name = "join_date")
	private LocalDate joinDate;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	

	public Employee() {
		super();
	}

	public Employee(String name, String address, double salary, LocalDate joinDate) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.joinDate = joinDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id : "+getId()+" name=" + name + ", address=" + address + ", salary=" + salary + ", joinDate=" + joinDate
				+ ", department=" + department + "]";
	}
	
	
	
}
