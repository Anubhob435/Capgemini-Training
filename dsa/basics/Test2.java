package dsa.basics;

public class Test2 {
    public static void duplicateZeros(int[] arr) {
        int[] ary = new int[arr.length];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (c > arr.length - 1) {
                break;
            }
            if (arr[i] != 0) {
                ary[c] = arr[i];
                c++;
            } else {
                ary[c] = 0;
                c++;
                if (c < arr.length) {
                    ary[c] = 0;
                    c++;
                }
            }
        }
        for (int j=0; j<arr.length; j++) {
            arr[j] = ary[j];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
    }
}