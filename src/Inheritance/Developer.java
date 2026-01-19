package src.Inheritance;

public class Developer extends Employee {
	
	String technology;
	
	public Developer(int id, String name, double salary, String technology, int age, boolean gender) {
		super(id,name,salary,age,gender);
		this.technology=technology;
	}
	
	public void displayDeveloper() {
		displayEmp();
		System.out.println(technology);
	}
	
	public static void main(String[] args) {
		Developer d=new Developer(101,"NIl NITIN MUKESH",50000,"SpringBoot", 52, true);
		d.displayDeveloper();
	}

}
