package src.WeeklyTests;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
	public static void main(String[] args) {

		SortedSet<Integer> ss = new TreeSet<Integer>(new MyIntegerComparator());
		ss.add(100);
		ss.add(10);
		ss.add(30);
		ss.add(40);
		ss.add(30); // duplicate, ignored
		ss.add(50);
		ss.add(60);

		System.out.println(ss);

		// first()
		System.out.println("first() : " + ss.first());

		// last()
		System.out.println("last() : " + ss.last());

		// headSet() -> elements < 100
		System.out.println("headSet() : " + ss.headSet(100));

		// tailSet() -> elements >= 10
		System.out.println("tailSet() : " + ss.tailSet(10));

		// subSet() -> 30 <= elements < 60
		System.out.println("subSet() : " + ss.subSet(60,30));

		// comparator returns the mentioned Comparator
		System.out.println("comparator() : " + ss.comparator());
	}
}
