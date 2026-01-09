package src.operators;

public class operator5 {
	public static void main(String[] args) {
		/*
		int a = 2;
		int b = a++ + 30;
		int c = b++ + a++;
		*/
				
		int a = 3;
		int b = ++ a + a++;
		int c = b++ + ++a + b++ + a++;
		//System.out.println(++c + "" + ++a);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		
	}
}

