package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students_tbl")
public class Student extends BaseEntity {

	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(unique = true, length = 30)
	private String email;

	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> students = new ArrayList<Admission>();

	public List<Admission> getstudents() {
		return students;
	}

	public void setstudents(List<Admission> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Student " + getId() + "[firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addAdmission(Admission studentAddmission) {
		students.add(studentAddmission);
		studentAddmission.setStudent(this);
	}
}
