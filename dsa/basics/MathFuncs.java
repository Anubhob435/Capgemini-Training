package dsa.basics;

public class MathFuncs {
	
	public static boolean pows(int x) {
	
	if(x %2 != 0) {
		return false;
	}
	
	while(x != 2) {
		x = x/2;
		if ( x %2 != 0) {
			return false;
		}
	}
	
	return true;
}
	public static void main(String[] args) {
		System.out.println(pows(18));
	}

}
