package src.Polymorphism;

public class AreaCalc {
	static double calculateArea(double side) {
		System.out.println("Area of Square");
		return side * side;
	}
	static double calculateArea(double length, double breadth) {
		System.out.println("Area of rectangle ");
		return length * breadth;
	}
	static double calculateArea(float radius) {
		System.out.println("Area of circle");
		return 3.14 * radius * radius;
	}
	public static void main(String[] args) {
		System.out.println(calculateArea(10));
		System.out.println(calculateArea(7.7));
		System.out.println(calculateArea(5.2, 5.2));
	}
}
