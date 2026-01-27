package src.WeeklyTests;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {
	public static void main(String [] args) {
		
		NavigableSet<Integer> ns = new TreeSet<Integer>();

		ns.add(10);
		ns.add(30);
		ns.add(20);
		ns.add(50);
		ns.add(40);
		System.out.println(ns);
		System.out.println("lower() :"+ ns.lower(30)) ;
		System.out.println("floor() :"+ ns.floor(30));
		System.out.println("ceiling():"+ ns.ceiling(30));
		System.out.println("higher() : "+ ns.higher(30)) ;
		System.out.println("pollfirst() : "+ ns.pollFirst());
		System.out.println(ns);
		System.out.println("polllast() : "+ ns.pollLast()) ;
		System.out.println(ns);

		Iterator<Integer> itr = ns.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}