package src.Strings;

public class Movehypen {
	public static void main(String[] args) {
		String s = "Hello-Anubhob-today-is-Sunday";
		String s1 = "", s2 = "";
		
		for (int i =0; i<s.length(); i++) {
			if(s.charAt(i)=='-')
				s1 = s1 + "-";
		
			else 
				s2 = s2 + s.charAt(i);
			

		}
		System.out.println(s1+s2);
	}
}