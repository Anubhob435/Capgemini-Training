package src.WeeklyTests;
import java.util.Arrays;

//Given an array nums, return an array where each element is the product of all other elements.
public class ProductArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			int product = 1;
			for(int j = 0; j < arr.length; j++) {
				if(i != j) {
					product *= arr[j];
				}
			}
			result[i] = product;
		}
		
		System.out.println("Input: " + Arrays.toString(arr));
		System.out.println("Output: " + Arrays.toString(result));
	}
}
