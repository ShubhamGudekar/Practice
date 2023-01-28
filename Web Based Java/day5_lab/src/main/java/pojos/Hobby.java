package pojos;

import javax.persistence.Embeddable;

@Embeddable
public class Hobby {

	private String hobbies;

	public Hobby(String hobbies) {
		super();
		this.hobbies = hobbies;
	}

	public Hobby() {
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Hobby [hobbies=" + hobbies + "]";
	}

	
}
