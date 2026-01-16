package src.Encapsulation;

public class Test {

	public static void demo(Test obj) {
		System.out.println("demo()");
		System.out.println(obj);
		obj.test();//null.test()
	}
	
	public static void main(String[] args) {
		
		demo(new Test());
		demo(null);
	}
	
	public void test() {
		System.out.println("test()");
		
	}
}
