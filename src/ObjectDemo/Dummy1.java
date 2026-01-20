package src.ObjectDemo;

public class Dummy1 {
	public int hashCode() {
		return 100;
	}
	public static void main(String[] args) {
		Dummy1 d1 = new Dummy1();
		System.err.println(d1.hashCode());
	}
}
