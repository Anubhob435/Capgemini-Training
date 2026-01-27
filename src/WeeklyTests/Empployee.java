package src.WeeklyTests;
public class Empployee implements Comparable<Empployee>{
	
	int id;
	String name;
	double salary;

	public Empployee(int id , String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	// Decending Order
	public int compareTo(Empployee p) {
		if(this.salary < p.salary) {
			return 1;
		}else if(this.salary > p.salary) {
			return -1;
		}
		else {
			int result = this.name.compareToIgnoreCase(p.name);
			if(result < 0) {
				return 1;
			}else if(result >0) {
				return -1;
			}else {
				if(this.id < p.id) {
					return 1;
				}else if(this.id > p.id) {
					return -1;
				}else {
					return 0;
				}
			}	
		}
	}
	
	@Override
	public String toString() {
		return "Id: " + id + "\nName: " + name + "\nSalary: " + salary;
	}
}