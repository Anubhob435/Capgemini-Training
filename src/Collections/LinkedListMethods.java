package src.Collections;

import java.util.*;
public class LinkedListMethods {
	public static void main(String[] args) {
		
	
	LinkedList<String> list= new LinkedList<String>();
	//addfirst
	System.out.println(list);
	list.addFirst("A");
	list.addFirst("B");
	System.out.println("after addFirst()"+ list);
	System.out.println("=====================");
	System.out.println(list);
	list.addLast("C");
	list.addLast("D");
	System.out.println("=========================");
	//getfirst
	System.out.println(list);
	System.out.println("getFirst()"+list.getFirst());
	System.out.println(list);
	System.out.println("getlast()"+list.getLast());
	System.out.println("=========================");
	//getfirst
	System.out.println(list);
	System.out.println("removeFirst()"+list.removeFirst());
	System.out.println(list);
	System.out.println("removelast()"+list.removeLast());
	System.out.println("=========================");
	//getfirst
	System.out.println(list);
	System.out.println("offerFirst()"+list.offerFirst("E"));
	System.out.println(list);
	System.out.println("Offerlast()"+list.offerLast("G"));
	
	System.out.println("=========================");
	//getfirst
	System.out.println(list);
	System.out.println("pollFirst()"+list.pollFirst());
	System.out.println(list);

	System.out.println("=========================");
	//getfirst
	System.out.println(list);
	System.out.println("pollLast()"+list.pollLast());
	System.out.println(list);
	System.out.println("=========================");
	//getfirst
	System.out.println(list);
	System.out.println("peekFirst()"+list.peekFirst());
	System.out.println(list);
	System.out.println("=========================");
	//getfirst
	System.out.println(list);
	System.out.println("peekLast()"+list.peekLast());
	System.out.println(list);
	
	// descending iterator
	Iterator<String> itr = list.descendingIterator();
	while(itr.hasNext()) {
	System.out.println(itr.next());
	}
	}
}