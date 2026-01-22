package src.Abstraction;

abstract class B{
	public abstract void testA();
	void keepA() {
		System.out.println("polu");
		}
	}

class C extends B {

	@Override
	public void testA() {
		System.out.println("test in C is called");
		
	}
	public void keepB() {
		System.out.println("keep1 from c");
	}

}
public class A{
	public static void main(String[] args) {
		B b=new C();//upcasting
		b.testA();
		b.keepA();
		
		C c=(C)b;
		c.testA();
		c.keepA();
		c.keepB();
		
		
	}
}