package src.Main;
import java.util.*;
public class Practice1 {



	    public static char mostFrequent(String text) {
	        Map<Character, Integer> freq = new HashMap<>();

	        // Count frequency
	        for (char c : text.toCharArray()) {
	            freq.put(c, freq.getOrDefault(c, 0) + 1);
	        }

	        int maxFreq = 0;
	        char result = text.charAt(0);

	        // Traverse string to preserve first appearance
	        for (char c : text.toCharArray()) {
	            int count = freq.get(c);
	            if (count > maxFreq) {
	                maxFreq = count;
	                result = c;
	            }
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        String text1 = "1223334444";
	        System.out.println(mostFrequent(text1));  // Output: 4

	        String text2 = "abeABCabc";
	        System.out.println(mostFrequent(text2));  // Output: a
	    }
	}