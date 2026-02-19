package src.Main;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Student> students = List.of(
			new Student("Alice", 72),
			new Student("Bob", 70),
			new Student("Charlie", 35),
			new Student("David", 45),
			new Student("Anohita", 69)
		);
		// List<Student> passed = students.stream()
		// .filter(s -> s.marks > 68) // not transform or mutate the data
		// .peek(s -> System.out.println("Passed: " + s.name))
		// .peek(s -> s.setMarks(s.marks* 2)) // mutate the data
		// .map(s -> new Student(s.name, s.marks *2 )) //transform the data
		// .toList();
		// System.out.println(passed.size());

//		List<Student> passed = students.stream()
//			.filter(s -> s.marks > 68) // not transform or mutate the data
//			.filter(s -> s.name.startsWith("A")) // not transform or mutate the data
//			.peek(s -> System.out.println("Passed and starts with 'A' " + s.name))
//			.toList();
//			System.out.println(passed.size());
		
		List<Student> updated = students.stream()
				.peek(s -> {
					if (s.marks < 60) {
						s.setMarks(60);
					}
				})
				.peek(s -> System.out.println(s.name + ": " + s.marks))
				.toList();
	}
}

class Student {
	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	
	public void setMarks(int n) {
		this.marks = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}
}
