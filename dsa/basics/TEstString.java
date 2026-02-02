package dsa.basics;

public class TEstString {
	public static void main(String[] args) {
		String st = "Google";
		String st3 = "google";
		
		String st2 = st.toLowerCase();
		
		System.out.println(st2);
		System.out.println(st2.equals(st3));
		System.out.println((st.substring(1,st.length())).equals(st3.subSequence(1, st3.length())));
	}

}
