package src.classes;

public class Program2 {
	static int  i = 20; // single line initializer
	static {
	i = 30;
	System.out.println(i);
	i = test1();
	System.out.println("Static block 1");
	}
	public static void main(String[] args) {
		System.out.println("Main start");
		System.out.println(i);
		System.out.println("Main end");
		
	}
	public static int test1() {
		System.out.println("Test1");
		System.out.println(i);
		return 100;
	}
	static {
		System.out.println("Static initilizer block 2");
	}

}
