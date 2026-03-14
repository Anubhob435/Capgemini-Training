package src.Main;

import java.util.*;

public class Main2 {

	public static long getMinimumIncrement(List<Integer> list) {

	    long moves = 0;

	    for (int i = 1; i < list.size(); i++) {

	        if (list.get(i) < list.get(i - 1)) {

	            int diff = list.get(i - 1) - list.get(i);
	            moves += diff;

	            list.set(i, list.get(i - 1));
	        }
	    }

	    return moves;
	}

    public static void main(String[] args) {

        // Sample input from the question
        List<Integer> arr = Arrays.asList(4, 1, 3, 5, 6, 5);

        long result = getMinimumIncrement(arr);

        System.out.println("Minimum increment required: " + result);
    }
}