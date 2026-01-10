package src.pattern;

public class pattern2 {
	    public static void main(String[] args) {
	        int n = 5;
	        
	        // Upper half (including middle row)
	        for (int i = 0; i < n; i++) {
	            int stars = n - i ;
	            
	            // Left stars
	            for (int j = 0; j < stars; j++) {
	                System.out.print("* ");
	            }
	            
	            // Middle spaces (only if not first row)
	            if (i > 0) {
	                for (int j = 0; j < 2 * i; j++) {
	                    System.out.print("  ");
	                }
	            }
	            
	            // Right stars (only if not first row)
	            if (i > 0) {
	                for (int j = 0; j < stars; j++) {
	                    System.out.print("* ");
	                }
	            }
	            
	            System.out.println();
	        }
	        
	        // Lower half (mirror of upper, excluding middle)
	        for (int i = n - 2; i >= 0; i--) {
	            int stars = n - i;
	            
	            // Left stars
	            for (int j = 0; j < stars; j++) {
	                System.out.print("* ");
	            }
	            
	            // Middle spaces (only if not first row)
	            if (i > 0) {
	                for (int j = 0; j < 2 * i; j++) {
	                    System.out.print("  ");
	                }
	            }
	            
	            // Right stars (only if not first row)
	            if (i > 0) {
	                for (int j = 0; j < stars; j++) {
	                    System.out.print("* ");
	                }
	            }
	            
	            System.out.println();
	        }
	    }
	}
