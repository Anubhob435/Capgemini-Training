package src.Collections;

import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		
		hs.add(10);
		hs.add(30);
		hs.add(2);
		hs.add(10);
		hs.add(2);
		hs.add(100);
		
		System.out.println(hs);
	}
}
