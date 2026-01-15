package src.Strings;

public class Answers1 {
	public static void main(String[] args) {
		String s = "aabaabbbcccd";
		String newS = "";
		
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (newS.indexOf(currentChar) == -1) {
				newS = newS + currentChar;
			}
		}
		System.out.println(newS);
	}
}
