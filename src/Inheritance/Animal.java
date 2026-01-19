package src.Inheritance;

public class Animal {

	String name;
	public Animal() {
		
	}

	public Animal(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(name + " is eating");
	}

	public void hunt() {

		System.out.println("Tiger is hunting");

	}
	public void sound() {
		System.out.println("makes meow meow");
	}

}