package dsa;

import java.util.Arrays;

public class LargeSmall {
	public static void main(String[] args) {
		int arr[] = {10, 51, 99, 69, 96, 15, 12};
		Arrays.sort(arr);
		System.out.println("Largest " + arr[arr.length-1]);
		System.out.println("Second Largest " + arr[arr.length-2]);
		System.out.println("Smallest "+ arr[0]);
		System.out.println("Second Smallest " + arr[1]);
		
		int smallest = Integer.MIN_VALUE;
		int secsmallest =  Integer.MIN_VALUE;
		int largest =  Integer.MAX_VALUE;
		int secondlargest =  Integer.MAX_VALUE;
		
		for(int i = 1; i< arr.length; i++) {
			if (i ==0) {
				
			}
		}


	}

}
