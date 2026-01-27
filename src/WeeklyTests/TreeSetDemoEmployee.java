package src.WeeklyTests;

import java.util.TreeSet;

public class TreeSetDemoEmployee {
	public static void main(String[] args) {
		
		
		TreeSet<Empployee> ts = new TreeSet<Empployee>();
		
		
		Empployee p1 = new Empployee(3, "Rohit", 70000);
		Empployee p2 = new Empployee(1, "Shyam", 30000);
		Empployee p3 = new Empployee(2, "Virat", 30000);
		Empployee p4 = new Empployee(4, "Hari", 40000);
		Empployee p5 = new Empployee(5, "Hari", 40000);
		Empployee p6 = new Empployee(4, "Hari", 40000);
		
		
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		ts.add(p5);
		ts.add(p6);


		System.out.println(ts);
		
	}
}