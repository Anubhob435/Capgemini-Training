package dsa;

public class TwoDarray {
	 public static void main(String[] args) {
		 int [] arr  = {10, 20, 30, 40, 50};
		 int position = 2;
		 int ele = 555;
		 
		 int [] arr2 = new int[arr.length+1];
		 
		 for(int i = 0; i< position; i++) {
			  arr2[i] = arr[i]; 
		 }
		 arr2[position] = ele;
		 
		 for(int j = position; j<arr.length; j++) {
			 arr2[j+1] = arr[j];
		 }
		 
		 for(int k = 0; k< arr2.length; k++) {
			 System.out.print(arr2[k] + ", ");
		 }
		
	 }
}
