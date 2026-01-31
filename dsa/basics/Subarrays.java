package dsa.basics;

import java.util.*;

public class Subarrays {
	public static List<List<Integer>> getSubarrays(List<Integer> list, int k) {
	    List<List<Integer>> result = new ArrayList<>();
	    int n = list.size();
	    
	    for (int i = 0; i <= n - k; i++) {
	        List<Integer> subarray = list.subList(i, i + k);
	        result.add(new ArrayList<>(subarray));
	    }
	    
	    return result;
	}
	public static void main(String[] args) {
	    List<Integer> list = Arrays.asList(101, 26, 13, 45, 59, 65, 77);
	    Collections.sort(list);
	    int k = 4;
	    List<List<Integer>> subarrays = getSubarrays(list, k);
	    System.out.println(subarrays);
	    int unfairness = 100000000;
	    for (List<Integer> subarray : subarrays) {
	    	System.out.println(subarray);
	    	Collections.sort(subarray);
	        System.out.println(subarray.get(0)+ " smallest ");
	        System.out.println(subarray.get(k-1) + " largest");
	        int xyz = subarray.get(k-1) - subarray.get(0);
	        System.out.println(xyz  + " unfairness");
	        
	        if (xyz < unfairness) {
	        	unfairness = xyz;
	        }
	    }
	    
	    System.out.println("Final smallest unfairness is " + unfairness);
	}

}
