package src.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Traverse_remove {


	public static void main(String[] args) {
		
		ArrayList<String> languages = new ArrayList<String>();
		languages.add("java");
		languages.add("python");
		languages.add("C");
		languages.add("C++");
		
		for (String s : languages) {
			if(s.equals("python")) {
				languages.remove(s);
			}
		}
		
		System.out.println("====================");
		/*
		Iterator <String> itr = languages.iterator();
		
		while(itr.hasNext()) {
			if(itr.next().equals("ython")) {
				itr.remove();
			}
		}
		*/
		System.out.println(languages);
		
		ListIterator <String> itr2 = languages.listIterator();
		
		System.out.println(languages);
		
		while(itr2.hasNext()) {
			if(itr2.next().equals("python")) {
				itr2.remove();
			}
		}
		System.out.println(languages);
}
}