package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emps")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "password")
public class Employee extends BaseEntity {

	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@Column(length = 20)
	// @JsonProperty(value="location")
	// Annotation to map property with different name on Frontend
	private String workLocation;
	@Column(length = 20)
	private String department;

	private LocalDate joinDate;

	private double salary;

}
