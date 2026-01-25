package src.Collections;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTask1 {
	public static void main(String[] args) {
	
	ArrayList list = new ArrayList();
	
	list.add(100);
	list.add(100.50);
	list.add("Hello");
	list.add(true);
	list.add("World");
	
	ListIterator itr = list.listIterator();
	
	while(itr.hasNext()) {
		Object obj = itr.next();
		if(obj.equals("Hello") || obj.equals("World")) {
			itr.remove();
		}
	}
	
	System.out.println("List after removal: " + list);
	}
}