package src.Abstraction;

//Concrete class extending the abstract Payment class
class UPIPayment extends Payment {
 
 // Variable specific to this class (as shown in the diagram: "UPIApp")
 String upiApp; 

 // Constructor
 public UPIPayment(double amount, String upiApp) {
     super(amount);        // Passes 'amount' to the parent Payment class constructor
     this.upiApp = upiApp; // Initializes the local 'upiApp' variable
 }

 // Overriding the concrete method to add more info
 @Override
 public void paymentInfo() {
     super.paymentInfo(); // Prints the amount using the logic in the parent class
     System.out.println("App used: " + upiApp);
 }

 // Implementing the abstract method required by the parent class
 @Override
 public void makePayment() {
     // Logic for UPI payment
     System.out.println("Payment is done using " + upiApp);
 }
}