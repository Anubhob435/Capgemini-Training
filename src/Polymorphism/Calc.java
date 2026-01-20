package src.Polymorphism;
import java.util.Scanner;
public class Calc extends AreaCalc {
	static int add(int a, int b) {
		return a + b;
	}
	static double add(double a, double b) {
		return a - b;
	}
	public static void main(String[] args) {
		//AreaCalc Calculator = new AreaCalc();
		System.out.println("Enter \n1. TO CALCULATE AREA OF SQUARE\n2. TO CALCULATE AREA OF RECTANGLE\n3. TO CALCULATE AREA OF CIRCLE");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		switch(n) {
		case 1:
			System.out.println("enter side");
			double side=sc.nextInt();
		System.out.println(calculateArea( side));
			break;
			
		case 2:
			System.out.println("enter length and breadth in double");
			double length=sc.nextInt();
			double breadth=sc.nextInt();
			System.out.println(calculateArea(length,breadth));
			break;
		
		case 3:
			System.out.println("enter radius in float");
			float radius=sc.nextInt();
			
			System.out.println(calculateArea(radius));
			break;
		
		case 4:
			System.out.println("Invalid choice");
			break;
		
		}
		sc.close();
	}
}
