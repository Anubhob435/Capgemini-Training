package src.Main;

public class Multi_Threading {
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			Logic th = new Logic(i);
			th.start();
		}
	}
}