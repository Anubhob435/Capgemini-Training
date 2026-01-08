package src.Tokens;

import java.util.Scanner;
public class program1 {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("What is the Student name? ");
		String name = sc.nextLine();
		System.out.println("What is your Date of birth as DD/MM/YYYY ");
		String dob = sc.nextLine();
		String [] dob_array = dob.split("/");
		int birth_year = Integer.valueOf(dob_array[2]);
		int birth_month = Integer.valueOf(dob_array[1]);
		//int birth_date= Integer.valueOf(dob_array[0]);
		
		int age = 0;
		//int TodayDay = 8;
		int TodayMonth = 1;
		int TodayYear = 2026;
		if (birth_month >= TodayMonth) {
			age = TodayYear - birth_year - 1;
		}
		else {
			age = TodayYear - birth_year ;
		}

		System.out.println("Hello " + name + " You are " + age + " years old");
		sc.close(); 
	}
}
