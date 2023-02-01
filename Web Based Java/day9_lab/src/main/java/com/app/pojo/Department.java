package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Department extends BaseEntity {

	@Column(unique = true)
	private String name;

	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [ id : "+getId()+" name : " + name + "]";
	}
	
	
	
	
}
