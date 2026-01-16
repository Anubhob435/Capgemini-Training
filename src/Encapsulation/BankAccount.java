package src.Encapsulation;

public class BankAccount{

	
	int acno;
	String name;
	double balance;
	
	BankAccount(){
		
	}
	BankAccount(int acno,String name,double balance){
		this.acno=acno;
		this.name=name;
		this.balance=balance;
	}
	public void deposit(double amt) {
		if(amt>=0) {
		balance=balance+amt;
		System.out.println("Amount of "+amt+"Credited to your Account"+acno);
		System.out.println("Current Balance "+balance);
		}else {
			System.out.println("invalid amount Transaction cannot complete");
		}
	}
	
	public void withdraw(double amt) {
		if(amt<=balance) {
			balance=balance-amt;
			System.out.println("Amount of "+amt+"Debited from your Account "+acno);
			System.out.println("Current Balance "+balance);
		}else {
			System.out.println("invalid amount Transaction cannot complete");
		}
	}
	
	public void detials() {
		System.out.println("Account no:"+acno);
		System.out.println("Account holder name :"+name);
		System.out.println("Account Balance : "+balance); 
	}
}
