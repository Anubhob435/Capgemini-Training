package src.WeeklyTests;

public class ReArrange {
	public static void main(String[] args) {
		int [] arr = {1,0,2,1,1,0,0,2,1,0,2};
		int [] arr2 = new int[arr.length];
		int currentIndex = 0;
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			if(arr[i] == 0) {
				arr2[currentIndex] = 0;
				currentIndex++;
			}
		}
		for(int i = 0; i < len; i++) {
			if(arr[i] == 2) {
				arr2[currentIndex] = 2;
				currentIndex++;
			}
		}
		for(int i = 0; i < len; i++) {
			if(arr[i] == 1) {
				arr2[currentIndex] = 1;
				currentIndex++;
			}
		}
		for(int i = 0; i < len; i++) {
			System.out.print(arr2[i] + " ");
		}
 	}

}
