package src.Tokens;

class Test {
    public static void main(String[] args) {
        int[] a = {3, 2, 5, 10, 7};
        System.out.println(f(a, 0));
    }

    static int f(int[] b, int i) {
        if (i >= b.length) return 0;
        int x = b[i] + f(b, i + 2);
        int y = f(b, i + 1);
        return Math.max(x, y);
    }
}