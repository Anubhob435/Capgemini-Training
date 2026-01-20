package src.Inheritance;

public class AA2 extends AA1{

	int a = 20;

	public void message() {
	System.out.println("A2 message()");
	}
	
	public void display() {
	
	System.out.println(a); // child class variable
	System.out.println(super.a); // parent class variable
	
	message(); // child class method
	super.message();
	}

	
	public static void main(String[] args) {
	AA2 a2 = new AA2();
	
	a2.display();
	}
}