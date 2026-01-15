package src.Strings;

public class Program3 {
	public static void main(String[] args) {
		System.out.println("83456".matches("[6-9]\\d+"));
		System.out.println("98765432101134".matches("[6-9]\\d+"));
		System.out.println("98765432101134".matches("[6-9]\\d{9}"));
		System.out.println("98765432101134".matches("[6-9]\\d<9,}"));
		System.out.println("98765432101134".matches("[6-9]\\d{9,12}"));
	}
}
