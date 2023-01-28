package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects_tbl")
public class Project extends BaseEntity {
	
	@Column(length=50,unique = true)
	private String title;
	
	@Column(name="completion_date")
	private LocalDate completionDate;
	
	@ManyToMany
	@JoinTable(name = "project_students", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students = new ArrayList<Student>();
	
	public Project(String title, LocalDate completionDate) {
		this.title = title;
		this.completionDate = completionDate;
	}

	public Project() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	@Override
	public String toString() {
		return "Project [title=" + title + ", completionDate=" + completionDate + ", getId()=" + getId() + "]";
	}
	
	
	
	
}
