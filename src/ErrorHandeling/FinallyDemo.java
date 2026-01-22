package src.ErrorHandeling;

public class FinallyDemo {
	public static void main(String[] args){
		
		try {
			System.out.println("Program started");

			System.out.println("statement 1");

			System.out.println(100/0);

			System.out.println("statement 2");


			System.out.println("Program ended");
		}
			catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
			finally {
			System.out.println("statment 3");
		}
	}
}