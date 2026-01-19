package src.Inheritance;

public class TestCasting {

	public static void main(String[] args) {
		Animal a = new WhiteTiger();
		a.sound();    // allowed
		System.out.println();
		Tiger t = (Tiger) a;
		t.sound();   // inherited
		t.hunt();    // allowed
		System.out.println();

		WhiteTiger wt = new WhiteTiger();
		wt.sound();
		wt.hunt();
		wt.rare();

	}

}