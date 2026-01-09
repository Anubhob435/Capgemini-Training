package src.loops;

public class prime {
	public static boolean isPrime(int n) {
		boolean prime = true;
		if (n<=0)
			return false;
		else if(n == 2)
			return true;
		else {
			for (int i =2 ; i< n; i++) {
				if (n%i == 0) {
						prime = false;
						break;
						}
			}
		}	
		return prime;
	}
	public static void main(String[] args) {
		for(int j =0; j<= 100; j++) {
		boolean ans = isPrime(j);
		if (ans)
			System.out.println(j + " is prime");
		else
			System.out.println(j + " is not prime");
		
		}
	}
		
}
