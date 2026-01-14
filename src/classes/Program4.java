package src.classes;

public class Program4 {
	static {
		System.out.println("Static Block 1");
	}
	{
		System.out.println("Static Block 1");
	}
	public static void main(String[] args) {
		System.out.println("Main");
		new Program4();
		new Program4();	
	}

}
