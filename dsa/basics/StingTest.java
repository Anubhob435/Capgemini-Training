package dsa.basics;

public class StingTest {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        StringBuilder sb2 = new StringBuilder(sb);
        sb2.reverse();

        System.out.println(sb);
        System.out.println(sb2);

        return sb.toString().equals(sb2.toString());
    }
    
    public static void main(String[] args) {
		System.out.println(isPalindrome("abcdcba"));
	}
}
