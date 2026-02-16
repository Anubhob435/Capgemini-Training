package dsa.basics;

import java.util.Arrays;

public class EnterElementArray {
    public static void main(String[] args) {
        int ele = 105;
        boolean placed = false;
        int[] arr = {101, 102, 107, 110, 115};
        int[] arr2 = new int[arr.length + 1];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ele) {
                arr2[c] = arr[i];
                c++;
            } else {
                if (!placed) {
                    arr2[c] = ele;
                    c++;
                    placed = true;
                }
                arr2[c] = arr[i];
                c++;
            }
        }
        if (!placed) { 
            arr2[c] = ele;
        }
        System.out.println(Arrays.toString(arr2));
    }
}