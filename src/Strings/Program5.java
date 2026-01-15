package src.Strings;

public class Program5 {
	public static void main(String[] args) {
		String s2 = "java!w#qse";
		String s = "@!#%^&";
		System.out.println(s.matches("[^a-zA-Z0-9]+"));
		
		String[] sarr=  s.split("[!#(]");
		
		for(int i =0; i<sarr.length; i++) {
			System.out.println(sarr[i]);
		}
	}
}
