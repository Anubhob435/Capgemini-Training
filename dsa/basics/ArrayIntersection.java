package dsa.basics;

public class ArrayIntersection {

	    public static char[] reverseString(char[] s) {
	        char[] news = new char[s.length];
	        int current_index = 0;
	        for (int i = s.length - 1; i >= 0; i--) {
	            news[current_index] = s[i]; // fix: s[i] instead of news[i]
	            current_index++;
	        }
	        return news;
	    }

	    public static void main(String[] args) {
	        char[] arr = {'h', 'e', 'l', 'l', 'o'};
	        char[] reversed = reverseString(arr);
	        System.out.println(java.util.Arrays.toString(reversed)); // print output
	    }
	}