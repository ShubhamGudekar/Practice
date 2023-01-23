package pojo;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "emps", uniqueConstraints = @UniqueConstraint(columnNames = { "first_name", "last_name" }))
//table name emps with unique constraint on first_name and last_name
public class Employee {
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "emp_id") // column name = emp_id
	private Long id;

	@Column(name = "first_name", length = 30) // column name = first_name and varchar(30)
	private String firstName;

	@Column(name = "last_name", length = 30) // column name = last_name and varchar(30)
	private String lastName;

	@Enumerated(EnumType.STRING) // column type : varchar
	@Column(length = 25) // varchar(25)
	private Department dept;

	private double salary;

	private LocalDate dob;

	@Column(name = "is_permanent")
	private boolean isPermanent;

	public Employee(String firstName, String lastName, Department dept, double salary, LocalDate dob,
			boolean isPermanent) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.salary = salary;
		this.dob = dob;
		this.isPermanent = isPermanent;
	}

	public Employee() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

}
