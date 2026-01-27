package src.WeeklyTests;

import java.util. TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
	
	/*TreeSet<String> ts = new TreeSet<String>();
	ts.add("K");
	ts.add("Z");
	ts.add("A");
	ts.add("Z");
	
	System.out.println(ts); */
	
	
	TreeSet<Product> ts = new TreeSet<Product>();
	Product p1 = new Product(3, "Iphone", 70000);
	Product p2 = new Product(1, "Samsung Mobile", 30000);
	Product p3 = new Product(2, "Samsung Mobile", 30000);
	Product p4 = new Product(1, "MI Mobile", 40000);

	ts.add(p1);
	ts.add(p2);
	ts.add(p3);
	ts.add(p4);

	System.out.println(ts);
		}
	}