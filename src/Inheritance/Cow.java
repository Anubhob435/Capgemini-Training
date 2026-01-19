package src.Inheritance;

public class Cow extends Animal {

	public Cow(String name) {
		super(name);
	}

	public void moo() {
		System.out.println(name + " says Moo");
	}
}