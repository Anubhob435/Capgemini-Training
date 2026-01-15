package src.Strings;

public class Anagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        
        return java.util.Arrays.equals(arr1, arr2);
    }
    
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        
        if (isAnagram(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }
}
