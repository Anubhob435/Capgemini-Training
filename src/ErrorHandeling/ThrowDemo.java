package src.ErrorHandeling;

public class ThrowDemo {
	public static void vote(int age) throws ClassNotFoundException {

	if(age >= 18 ) {

	System.out.println("Candidate voted");
	}
	else {
	//	try {
	//throw new ArithmeticException();
	throw new ClassNotFoundException();
	}
	//catch(ArithmeticException e) {
	//System.out.println("Cannot Vote ");
	}
	public static void main(String[] args) {

	System.out.println("Candadate went for voting");
	try {
		vote(17);
	}

	catch(Throwable t) {
	System.out.println("Candidate cannot vote");
	}
	System.out.println("canidate came home");
	}

}
