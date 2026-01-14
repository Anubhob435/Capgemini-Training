package src.classes;

public class Person {
	String name;
	int age;
	String gender;
	Person(){
		
	}
	Person(int a){
		System.out.println("Hello ");
	}
	
	public void display() {
		System.out.println("this: " + this);
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("gender " + gender);
	}
	
	Person(String name, int age, String gender) {
		System.out.println("this: " + this);
		this.name = name;
		this.age=age;
		this.gender=gender;
	}
	
}
