package src.Collections;

import java.util.*;

public class Student {
	int roll;
	String name;
	double marks;
	
	public Student(int roll, String name, double marks) {
			this.roll= roll;
			this.name= name;
			this.marks=marks;
	}
	
	public void display() {
		System.out.println("Roll: " + roll + ", Name: " + name + ", Marks: " + marks);
	}
	
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "Alice", 85.5));
		students.add(new Student(2, "Bob", 90.0));
		students.add(new Student(3, "Charlie", 78.5));
		
		System.out.println("Student Details:");
		for(Student s : students) {
			s.display();
		}
	}
}