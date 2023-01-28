package pojos;

import javax.persistence.Embeddable;

@Embeddable
public class EducationalQualification {

	private String type;
	
	private int year;
	
	private int marks;

	public EducationalQualification(String type, int year, int marks) {
		super();
		this.type = type;
		this.year = year;
		this.marks = marks;
	}

	public EducationalQualification() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "EducationalQualification [type=" + type + ", year=" + year + ", marks=" + marks + "]";
	}
	
	
	
	
}
