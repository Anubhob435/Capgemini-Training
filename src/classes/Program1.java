package src.classes;

public class Program1 {
	static int i = test();
	
	public static void main(String[] args) {
		System.out.println("Second");
		System.out.println("Third");
		System.out.println(i);
	}
	public static int test() {
		System.out.println("First");
		return 0;
	}
}
