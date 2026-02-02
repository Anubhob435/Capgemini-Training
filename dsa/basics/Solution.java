package dsa.basics;

class Solution {
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
    	String [] arr = {"flower","flow","flight"};
    	longestCommonPrefix(arr);
	}
}