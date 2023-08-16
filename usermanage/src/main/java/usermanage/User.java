package usermanage;

import java.io.Serializable;


public class User implements Serializable{
	private String name;
	private String email;
	private int birthYear;
	
	public User(String name, String email, int birthYear) {
		this.name = name;
		this.email = email;
		this.birthYear = birthYear;
		
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", birthYear=" + birthYear + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

}
