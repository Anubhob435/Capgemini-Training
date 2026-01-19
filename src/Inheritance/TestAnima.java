package src.Inheritance;

public class TestAnima {
	public static void main(String[] args) {

		Cat c = new Cat("Kitty");
		c.eat();
		c.meow();

		System.out.println();

		Dog d = new Dog("Bruno");
		d.eat();
		d.bark();

		System.out.println();

		Cow cow = new Cow("Ganga");
		cow.eat();
		cow.moo();
	}

}
