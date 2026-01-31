package dsa.basics;

public class DeleteElement {
	public static void main(String[] args) {
		int arr[] = {10, 51, 12, 69, 96, 15, 12};
		int k = 12;
		
		for( int i = 0; i< arr.length; i++) {
			if (arr[i] ==k) {
					arr[i] =0;
					break;
			}
			
		}
		for( int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
