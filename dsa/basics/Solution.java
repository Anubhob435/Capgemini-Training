package dsa.basics;

class Solution {
	
	public static String convertToTitle(int columnNumber) {
	    StringBuilder sb = new StringBuilder();
	    while (columnNumber > 0) {
	        columnNumber--;
	        sb.append((char) ('A' + columnNumber % 26));
	        columnNumber /= 26;
	    }
	    return sb.reverse().toString();
	}
	
    public static int titleToNumber(String columnTitle) {
        int multiplier = 1;
        int [] arr = new int[columnTitle.length()];
        for (int i =0; i< columnTitle.length(); i++){
            arr[i] = columnTitle.charAt(i) - 64;
        }
        for (int i =0; i< columnTitle.length(); i++){
            System.out.println(arr[i]);
        }
        
        return 0;

    }
	
	
	
    public static String longestCommonPrefix(String[] strs) {

        String output = strs[0];
        for(String j : strs ){
            if(j.length()<output.length()){
                output = j;
            }
        }
        System.out.println(output);
        
        if(strs.length==0) return "";

        for(int i = 0; i< strs.length; i++){
            
        }
        return output;
    }
    public static void main(String[] args) {
    	titleToNumber("ABCDERFGZ");
	}
}