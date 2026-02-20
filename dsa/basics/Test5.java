package dsa.basics;

public class Test5 {
    public static int reverse(int x) {
        String st = String.valueOf(x);
        String revs= "";
        for(int i = st.length() -1 ; i>=0; i--){
            revs += st.charAt(i);
        }
        int xy = Integer.valueOf(revs);
        return xy;

    }
    public static void main(String[] args) {
		System.out.println(reverse(123));
	}
}

