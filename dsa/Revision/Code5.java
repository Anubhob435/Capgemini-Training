package dsa.Revision;

import java.util.*;
import java.util.stream.Collectors;

public class Code5 {
    public static void sortByBits(int[] arr) {
        Map<Integer, String> binaryMap = new HashMap<>();
        
        for (int num : arr) {
            binaryMap.put(num, Integer.toBinaryString(num));
        }
        Map<String, Integer> onesCountMap = new HashMap<>();
            for (String binary : binaryMap.values()) {
                int count = (int) binary.charAt(0) == '1' ? 1 : 0;
                    for (int i = 1; i < binary.length(); i++) {
                        if (binary.charAt(i) == '1') count++;
                    }
            onesCountMap.put(binary, count);
        }

		Map<String, Integer> sortedMap = onesCountMap.entrySet().stream()
		    .sorted(Map.Entry.<String, Integer>comparingByValue()
		        .thenComparing(e -> Integer.parseInt(e.getKey(), 2)))
		    .collect(Collectors.toMap(
		        Map.Entry::getKey, 
		        Map.Entry::getValue, 
		        (e1, e2) -> e1, 
		        LinkedHashMap::new
		    ));
		int[] sortedNums = Arrays.stream(arr)
			    .boxed()
			    .sorted((a, b) -> {
			        int countA = Integer.bitCount(a);
			        int countB = Integer.bitCount(b);
			        if (countA == countB) {
			            return Integer.compare(a, b);
			        }
			        return Integer.compare(countA, countB);
			    })
			    .mapToInt(Integer::intValue)
			    .toArray();

			System.out.println(Arrays.toString(sortedNums));
                
        System.out.println(sortedMap); 
        System.out.println(onesCountMap);
    }
    
    public static void main(String[] args) {
		int arr[] = {0,1,2,3,4,5,6,7,8};
		
		sortByBits(arr);
	}

}
