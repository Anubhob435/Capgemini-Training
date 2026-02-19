package src.Main;

import java.util.List;
import java.util.stream.Collectors;

class Soln{
	String name;
	int age;

	public Soln(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
}

class Person {
	public static void main(String[] args) {
		List<Soln> persons = List.of(
				new Soln("Alice", 20),
				new Soln("Bob", 17),
				new Soln("Charlie", 35),
				new Soln("David", 25),
				new Soln("Anohita", 69)
			);
		
		// 1. Get names of all students
		List<String> names = persons.stream()
				.map(Soln::getName)
				.collect(Collectors.toList());
		System.out.println("Names: " + names);
		
		// 2. Count Adults (age >= 18)
		long adultCount = persons.stream()
				.filter(p -> p.getAge() >= 18)
				.count();
		System.out.println("Adult Count: " + adultCount);
		
		// 3. Double age of adults and collect with age between 18 & 48
		List<Soln> doubledAdults = persons.stream()
				.filter(p -> p.getAge() >= 18)
				.map(p -> new Soln(p.getName(), p.getAge() * 2))
				.filter(p -> p.getAge() >= 18 && p.getAge() <= 48)
				.collect(Collectors.toList());
		System.out.println("Doubled Adults (18-48): " + doubledAdults);
		
		// 4. Find first minor student (age < 18)
		persons.stream()
				.filter(p -> p.getAge() < 18)
				.findFirst()
				.ifPresent(p -> System.out.println("First Minor: " + p.getName()));
		
		// 5. Sum of ages of Adults only
		int ageSum = persons.stream()
				.filter(p -> p.getAge() >= 18)
				.mapToInt(Soln::getAge)
				.sum();
		System.out.println("Sum of Adult Ages: " + ageSum);
		
		// 6. Check if all students are adults
		boolean allAdults = persons.stream()
				.allMatch(p -> p.getAge() >= 18);
		System.out.println("All Adults: " + allAdults);
	}
}