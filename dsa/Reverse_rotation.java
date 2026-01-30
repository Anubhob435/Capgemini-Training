package dsa;

public class Reverse_rotation {
    public static void main(String[] args) {

        int[] arr = {10, 60, 20, 30, 40};
        int n = arr.length;
        int key = 2;

        key = key % n;


        reverse(0, n - key - 1, arr);
        reverse(n - key, n - 1, arr);
        reverse(0, n - 1, arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reverse(int start, int end, int[] arr) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}