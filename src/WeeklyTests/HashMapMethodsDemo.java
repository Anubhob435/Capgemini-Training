package src.WeeklyTests;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMethodsDemo {
	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(1, "Java");
		hm.put(2, "Python");
		hm.put(3, "C#");
		hm.put(4, "sql");
		hm.put(5, "rust");
		hm.put(1, "go lang");

		System.out.println(hm);
		System.out.println("get():"+hm.get(1));
		System.out.println("remove():"+hm.remove(5));
		System.out.println(hm);
		System.out.println("containsKey():"+hm.containsKey(4));
		System.out.println("containsValue()"+ hm.containsValue("C#"));
		System.out.println("size()" + hm.size());
		System.out.println("isEmpty()"+hm.isEmpty());
		Set<Integer> keys= hm.keySet();
		System.out.println(keys);
		
		Collection<String> values = hm.values();
		System.out.println(values);

		for(Entry<Integer, String> e : hm.entrySet()) {

		System.out.println(e.getKey() + " : " + e.getValue()) ;

		}
		System.out.println(hm.replace(4, "mysql"));
		System.out.println(hm);

		System.out.println(hm.remove(1, "go lang"));
		System.out.println(hm);
		
		
		
		
	}
}
