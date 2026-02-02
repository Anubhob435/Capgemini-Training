package dsa.basics;

import java.util.*;

public class Practice1 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int num : arr) {
		    freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		
		int maxFreq = 0;
		int maxElement = 0;
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
		    if (entry.getValue() > maxFreq) {
		        maxFreq = entry.getValue();
		        maxElement = entry.getKey();
		    }
		}
		System.out.println(maxElement);
		System.out.println(maxFreq);

	}

}
