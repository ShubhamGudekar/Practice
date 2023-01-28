package pojos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_tbl")
public class Address{
	
	@EmbeddedId
	@AttributeOverride(name = "id",column = @Column(name="student_id"))
	private Long id;
	
	@OneToOne
	private Student student; 
	
	private String city;
	
	private String state;
	
	private String country;
	
	@Column(name="zip_code")
	private String zipCode;

	public Address() {
		super();
	}

	public Address(String city, String state, String country, String zipCode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
	
	
}
