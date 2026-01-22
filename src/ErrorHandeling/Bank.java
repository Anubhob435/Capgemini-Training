package src.ErrorHandeling;

public class Bank {
	public static double balance = 10000;

	public static void debit(double amount) throws InvalidAmountException{

	if(amount > balance ) {
	throw new InvalidAmountException("Amount is greater than balance");
	}
	else {
	balance = balance- amount;
	System.out.println("amount debited");
		}
	}

	public static void main(String[] args) {
	System.out.println("Program started");
	try {
	debit(13000);
	}
	catch(InvalidAmountException a) {
	System.out.println(a.getMessage());
	}
	System.out.println("Program ended");
}
}
