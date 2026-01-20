package src.ObjectDemo;

public class Employee {

	int id; String name; double salary;
	
	Employee(int id, String name, double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
	
	public String toString() {
	 return "id= "+id+"\n"+"Name= "+name+"\nSalary= "+salary;	
	}
	
	public static void main(String[] args) {
		Employee emp=new Employee(1,"Rohit",50000);
		System.out.println(emp);
	}
}