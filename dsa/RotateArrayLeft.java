package dsa;

public class RotateArrayLeft {
	public static void main(String[] args) {
		int arr[] = {10, 51, 12, 69, 96, 15, 12};
		int len = arr.length;
		int k = 3;
		int [] newarr = new int[len];
		
		for(int i = 3; i< len; i++) {
			newarr[i-3] = arr[i];
		}
		for(int i = 0; i< k; i++) {
			newarr[i+4] = arr[i];
		}
		for(int i = 0; i< len; i++) {
			System.out.print(newarr[i] + " ");
		}
		
	}

}
