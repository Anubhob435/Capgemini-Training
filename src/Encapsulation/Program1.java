package src.Encapsulation;
public class Program1 {



	static {

		System.out.println("static block 1");

	}



	{

		System.out.println("non-static block 1");

	}



	int a = demo();// non-static initializer



	public static void main(String[] args) {



		new Program1();

		new Program1(10);



	}



	{

		System.out.println("non-static block 2");

	}



	static {

		System.out.println("static block 2");

	}



	Program1() {

		System.out.println("Program1()");

	}



	Program1(int a) {

		System.out.println("Program1(int a)");

	}



	public int demo() {

		System.out.println("demo()");

		return 10;

	}

}