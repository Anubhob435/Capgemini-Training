package src.Polymorphism;

public class Test {
	public static void main(String[] args) {
		Lion l=new Lion();
		l.sound();
		Dog d=new Dog();
		d.sound();
		
		Animal obj= new Dog();
		obj.sound();
		Animal obj1= new Lion();
		obj1.sound();
	}
}
