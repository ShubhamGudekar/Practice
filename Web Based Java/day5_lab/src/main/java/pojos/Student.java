package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> students = new ArrayList<Admission>();

	@ManyToMany(mappedBy = "students")
	private List<Project> projects = new ArrayList<Project>();

	@Embedded
	private AadharCard aadharCard;
	
	@ElementCollection
	@CollectionTable(name = "hobbies", joinColumns = @JoinColumn(name = "student_id"))
	private List<Hobby> hobbies = new ArrayList<Hobby>();

	@ElementCollection
	@CollectionTable(name = "educational_qualifications", joinColumns = @JoinColumn(name = "student_id"))
	private List<EducationalQualification> educationalQualifications = new ArrayList<EducationalQualification>();

	
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

	public List<Admission> getstudents() {
		return students;
	}

	public void setstudents(List<Admission> students) {
		this.students = students;
	}

	public List<Admission> getStudents() {
		return students;
	}

	public void setStudents(List<Admission> students) {
		this.students = students;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public List<EducationalQualification> getEducationalQualifications() {
		return educationalQualifications;
	}

	public void setEducationalQualifications(List<EducationalQualification> educationalQualifications) {
		this.educationalQualifications = educationalQualifications;
	}


	@Override
	public String toString() {
		return "Student " + getId() + "[firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
