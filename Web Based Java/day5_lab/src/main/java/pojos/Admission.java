package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "admissions_tbl", uniqueConstraints = @UniqueConstraint(columnNames = { "course_id", "student_id" }))
public class Admission extends BaseEntity {

	@Column(name = "applied_date")
	@CreationTimestamp
	private LocalDate appliedDate;

	@Column(name = "result_date")
	private LocalDate resultDate;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AdmissionStatus status;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Admission() {
	}

	public Admission(LocalDate appliedDate, LocalDate resultDate) {
		super();
		this.appliedDate = appliedDate;
		this.resultDate = resultDate;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public LocalDate getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Admission " + getId() + "[appliedDate=" + appliedDate + ", resultDate=" + resultDate + "]";
	}

	public AdmissionStatus getStatus() {
		return status;
	}

	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}
	
	

}
