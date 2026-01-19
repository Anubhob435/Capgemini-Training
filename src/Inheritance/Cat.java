package src.Inheritance;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	public void meow() {
		System.out.println(name + " says Meow");
	}

	public static void main(String[] args) {
		Cat c = new Cat("Kitty");
		c.eat();
		c.meow();
	}
}