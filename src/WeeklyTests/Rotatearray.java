package src.WeeklyTests;
import java.util.ArrayList;
public class Rotatearray {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7};
		int len = arr.length;
		ArrayList <Integer> array_2 = new ArrayList<Integer>();
		int k = 3;
		
		for (int i= len - k; i< len; i++) {
			//System.out.println(arr[i]);
			array_2.add(arr[i]);
		}
		for (int i= 0; i< len - k ; i++) {
			//System.out.println(arr[i]);
			array_2.add(arr[i]);
		}
		
		System.out.println(array_2);
		
		
	}
}
