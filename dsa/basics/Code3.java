package dsa.basics;

public class Code3 {
	public static void main(String[] args) {
		int n = 2147483644;
        String binary = Integer.toBinaryString(n);
        String extra_zero = "";
        System.out.println(binary + " " + binary.length());
        String revs = "";
        for(int i = 0; i < (32 - binary.length()); i++ ) {
        	extra_zero += "0";
        }
        extra_zero += binary;
        System.out.println(extra_zero + " " + extra_zero.length());
        for(int i = extra_zero.length() - 1; i>= 0; i--){
            revs += extra_zero.charAt(i); 
        }
        int decimal = Integer.parseInt(revs, 2); 
        System.out.println(decimal);
	}

}
