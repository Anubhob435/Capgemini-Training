package src.Inheritance;

public class Child extends Parent{
	
	public void childMethod() {
	System.out.println("Child method");
	}
	public static void main(String[] args) {
	
	// up casting
	Parent p = new Child();
	p.parentMethod();
	// p.childMethod();
	
	// down casting
	Child c = (Child)p;
	c.childMethod();
	c.parentMethod();
	
	
	
	Parent p2 = new Parent();
	System.out.println(p2 instanceof Parent);
	System.out.println(p2 instanceof Child);
	System.out.println(p2 instanceof Child);
	
	if(p2 instanceof Child) {
		Child c3 = (Child)p2;
	}

		else {
		System.out.println("Upcasting is not done");		}

		Child c2 = new Child();

		System.out.println(c2 instanceof Child);
		System.out.println(c2 instanceof Parent);

		Parent p4 = c2; // up casting

		if(p4 instanceof Child) {
		Child c5 = (Child)p4;
		System.out.println("Downcasting done");

		}
	}
}