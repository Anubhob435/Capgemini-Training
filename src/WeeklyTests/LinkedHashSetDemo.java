package src.WeeklyTests;
import java.util.*;

public class LinkedHashSetDemo {
	public static void main(String[] args) {
	
	LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
	hs.add(100);
	hs.add(10);
	hs.add(50);
	hs.add(70);
	
	System.out.println(hs);
	
	// iterate here using foreach, Iterator, ListIterator
	ArrayList<Integer> al = new ArrayList<Integer>(hs);
	ListIterator<Integer> itr = al.listIterator();
	while(itr.hasNext()) {
	System.out.println(itr.next());

	}
	
	}
}