package src.Encapsulation;

public class Test2 {
	
	public static void main(String[] args) {

		BankAccount account = new BankAccount(1,"Miller",2000);
		account.detials();
		account.deposit(1000);
		account.detials();
		account.withdraw(500);
		account.detials();
		account.deposit(-1000);
		account.withdraw(-1000);
		
	}
}
