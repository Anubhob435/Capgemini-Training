package dsa;

public class RotateArrayRight {
	public static void main(String[] args) {
		int arr[] = {10, 51, 99, 69, 96, 15, 12};
		int len = arr.length;
		int k = 3;
		int [] newarr = new int[len];
		
		for(int i = 0; i < len - k; i++) {
			newarr[i + k] = arr[i];
		}
		
		for(int i = len - k; i < len; i++) {
			newarr[i - (len - k)] = arr[i];
		}

		for(int i = 0; i < len; i++) {
			System.out.print(newarr[i] + " ");
		}
		
	}

}
