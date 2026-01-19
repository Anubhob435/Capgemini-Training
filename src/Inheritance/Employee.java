package src.Inheritance;

public class Employee extends Person{
	int id;
	String name;
	double salary;
	public Employee() {
		
	}
	public Employee(int id) {
		this.id =id;
	}
	public Employee(int id, String name) {
		this(id);
		this.name = name;
	}
	public Employee (int id, String name, double salary) {
		this(id, name);
		this.salary= salary;
	}
	public Employee (int id, String name, double salary, int age, boolean gender) {
		super(age, gender);
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public void displayEmp() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(salary);
		DisplayPerson();
		//System.out.println(age);
		//System.out.println(gender);
	}
	public static void main(String[] args) {
		
		//Employee e1 = new Employee();
		Employee e2 = new Employee(10);
		Employee e3 = new Employee(10, "Name");
		Employee e4 = new Employee(10, "Name", 100.20);
		
		
		System.out.println(e3.name);
		System.out.println(e2.id);
		System.out.println(e4.salary);
	}

}
