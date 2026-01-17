package src.Association;

public class Person {
	private String name;
	private String age;
	private String gender;
	
	private Passport passport;

	public void applyPassport() {
		
	}
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
