package dsa.Revision;

import java.util.Arrays;

public class Code2 {
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int [] arr = new int[2];
        int aliceSum = 0;
        int bobSum = 0;

        for(int i = 0; i< aliceSizes.length; i++){
            aliceSum += aliceSizes[i];
        }
        for(int i = 0; i< bobSizes.length; i++){
            bobSum += bobSizes[i];
        }

        int diff = Math.abs(aliceSum - bobSum);
        if (aliceSum > bobSum) {
        	
        }
        return arr;
    }
    
	public static void main(String[] args) {
		int [] aliceSizes = {1,1};
		int [] bobSizes = {2,2};
		System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
		
	}
}
