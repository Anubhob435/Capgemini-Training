package src.classes;

public class Student{
	String name;
	int age;
	String gender;
	Student(){
		
	}
	Student(int Marks){
		System.out.println("Marks Constructor ");
	}
	
	public void display() {
		System.out.println("this: " + this);
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("gender " + gender);
	}
	
	Student(String name, int age, String gender) {
		System.out.println("this: " + this);
		this.name = name;
		this.age=age;
		this.gender=gender;
	}
	
}
