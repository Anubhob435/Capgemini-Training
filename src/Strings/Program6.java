package src.Strings;

public class Program6 {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		System.out.println(sb.length());
		sb.append("1234567890123451");
		System.out.println(sb.capacity());
	}

}
