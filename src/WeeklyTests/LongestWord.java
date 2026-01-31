package src.WeeklyTests;

import java.util.Scanner;

public class LongestWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sentence: ");
		String inp = sc.nextLine();
		String [] arr = inp.split(" ");
		
		String longest = "";
		
		for(String i : arr) {
			if(i.length()> longest.length()) {
				longest = i;
			}
		}
		System.out.println(longest + " " + longest.length());
	}

}
