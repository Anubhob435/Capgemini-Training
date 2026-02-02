package dsa.basics;

public class CheckDups {
	public static void main(String[] args) {
        String str = "listen";
        char[] arr = str.toLowerCase().toCharArray();
        java.util.Arrays.sort(arr);
        
        char target = 'i';
        int index = java.util.Arrays.binarySearch(arr, target);
        
        if (index >= 0) {
            System.out.println("Char '" + target + "' found at index " + index);
        } else {
            System.out.println("Char '" + target + "' not found");
        }
    }

}
