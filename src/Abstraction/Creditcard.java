package src.Abstraction;

public class Creditcard {
	class CreditCard extends Payment {
	    String creditCompany;

	    public CreditCard(double amount, String creditCompany) {
	        super(amount);
	        this.creditCompany = creditCompany; 
	    }

	    @Override
	    public void paymentInfo() {
	        super.paymentInfo();
	        System.out.println("company : " + creditCompany);
	    }

	    @Override
	    public void makePayment() {
	        // logic
	        System.out.println("Payment is done using CreditCard");
	    }
	}
}