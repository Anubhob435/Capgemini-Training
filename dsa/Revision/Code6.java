package dsa.Revision;

import java.util.*;

public class Code6 {
    public static int countSegments(String s) {
        if(s.length() == 0) return 0;
        
        
        String[] arr =  s.split(" ");
        System.out.println(Arrays.toString(arr));
        return arr.length;
    }
    
    public static void main(String[] args) {
    	
    	
    	countSegments(", , , ,        a, eaefa");
	}
}
