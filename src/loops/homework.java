package src.loops;
//decimal to binary converter;
public class homework {
	public static int converter(int x) {
		int remainder = 0;
		while(x !=0) {
			remainder = remainder * 10 + (x % 2);
			x = x/2;
		}
		return remainder;
	}
	public static void main(String[] args) {
		System.out.println(converter(10));
	}
}
