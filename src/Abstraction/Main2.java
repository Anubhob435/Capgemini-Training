package src.Abstraction;

public class Main2 {
	public static void main(String[] args) {

		A1 a1 = new A3();
		a1.a();
		a1.a1();
//		a1.a2(); // CTE

		A3 a3 = (A3) a1;
		a3.a();
		a3.a1();
		a3.a2();
		a3.a3();
	}
}