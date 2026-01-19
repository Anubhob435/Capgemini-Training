package src.Inheritance;

public class B extends A{
	static int b = 500;
	
	public static void b() {
		System.out.println(b);
	}
	static {
		System.out.println("B static Block");
	}
	public static void main(String[] args) {
		System.out.println("B main()");
	}

}
