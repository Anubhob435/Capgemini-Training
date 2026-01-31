package dsa.basics;

import java.util.*;

public class InsertArray {
	
	public static int[] leftshift(int[] arr, int pos, int k) {
		for (int i = 0; i < pos; i++) {
			arr[i] = arr[i + 1];
		}
		return arr;
	}
	
	public static int[] rightshift(int[] arr, int pos, int k) {
		for (int i = arr.length - 1; i > pos; i--) {
			arr[i] = arr[i - 1];
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int n = 7;
		int k = n/2;
		int arr[] = new int[n];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter elements");
		for (int i = 0; i<k; i ++) {
			arr[i] = sc.nextInt();
		}
		arr[k] = 0;
		
		for (int i = k+1; i<n; i ++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i<n; i ++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\nEnter position, element");
		int pos = sc.nextInt();
		int ele = sc.nextInt();
		
		if(pos == k) {
			arr[k] = ele;
		}
		else if(pos < k) {
			arr = leftshift(arr, pos, k);
			arr[pos] = ele;
		}
		else if(pos > k) {
			arr = rightshift(arr, pos, k);
			arr[pos] = ele;
		}
		
		System.out.println("Array after insertion:");
		for (int i = 0; i<n; i ++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
		//  1 , 2 3 ,4,  5 ,6
	}
}
