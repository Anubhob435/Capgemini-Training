package src.ErrorHandeling;

public class Exception2 {
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5, 6};
		
		try {
			System.out.println(arr[7]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("index is invalid");
		}

	}
}
