package src.classes;

public class Program3 {
	String name;
	int age;
	String gender;
	
	public void display() {
		System.out.println("this: " + this);
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("gender " + gender);
	}
	
	public void initialize(String name, int age, String gender) {
		System.out.println("this: " + this);
		this.name = name;
		this.age=age;
		this.gender=gender;
	}
	
}
