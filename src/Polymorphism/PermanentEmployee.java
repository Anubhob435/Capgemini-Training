package src.Polymorphism;

public class PermanentEmployee extends Employee{
	double basicSalary;
	public PermanentEmployee(int id, String name, double basicSalary) {
	super(id, name);
	this.basicSalary = basicSalary;
	// TODO Auto-generated constructor stub
	}
	public void displayDetails() {
	super.displayDetails();
	System.out.println("basic salary" + basicSalary);
	}
	public double calculateSalary() {

	return basicSalary + (basicSalary * 0.20) + (basicSalary * 0.10);

	}
}
