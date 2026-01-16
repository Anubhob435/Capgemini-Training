package src.Inputs;

public class SumSubArray {
	public static void main(String[] args) {
		int [] arr = {1,2,3, 4};
		int len = arr.length;
		int sum = 0;
		for(int i = 0; i <len; i++) {
			for (int j= i; j<len; j++) {
				System.out.print("[");
				for (int k = i; k<=j; k++ ) {
					System.out.print(arr[k] + ",");
					sum = sum + arr[k];
					
				}
				System.out.print("]");
			}
			System.out.println();
			
		}
		System.out.println(sum);
	}
}
