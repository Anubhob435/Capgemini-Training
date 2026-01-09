package src.loops;

public class spyNum {
	public static void main(String[] args) {
		int num = 1242;
		int product = 1;
		int sum = 0;
		
		while (num !=0) {
			int modx = num % 10;
			sum = sum + modx;
			product = product * modx;
			num = num /10;
		}
		if (sum == product) {
			System.out.println("Spy Number");
		}
		else {
			System.out.println("Not a spy number");
		}
	}

}
