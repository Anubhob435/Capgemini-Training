package src.pattern;

public class pattern2 {
	    public static void main(String[] args) {
	        int n = 6;
	        
	        for (int i = 0; i < n; i++) {
	            int stars = n - i;
	            for (int j = 0; j < stars; j++) {
	                System.out.print("* ");
	            }
	            
	            for (int j = 0; j < 2 * i; j++) {
	                System.out.print("  "); // Two spaces per gap unit to align with "* "
	            }
	            
	            for (int j = 0; j < stars; j++) {
	                System.out.print("* ");
	            }
	            
	            System.out.println();
	        }
	        for (int i = n - 2; i >= 0; i--) {
	            int stars = n - i;
	            
	            for (int j = 0; j < stars; j++) {
	                System.out.print("* ");
	            }
	            
	            for (int j = 0; j < 2 * i; j++) {
	                System.out.print("  ");
	            }
	            
	            for (int j = 0; j < stars; j++) {
	                System.out.print("* ");
	            }
	            
	            System.out.println();
	        }
	    }
	}
