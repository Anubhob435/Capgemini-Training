package src.Polymorphism;

public class PayRollEmployee extends Employee {
	int hours;
	double rate;

	public PayRollEmployee(int id , String name, int hours, double rate) {
	super(id,name);
	this.hours = hours;
	this.rate =rate;
	}

	public void displayDetails() {
	super.displayDetails();
	System.out.println("hours" + this.hours);
	System.out.println("rate" + this.rate);
	}

	public double calculateSalary() {
	return hours * rate;
	}
}
