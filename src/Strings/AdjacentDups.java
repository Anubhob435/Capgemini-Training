package src.Strings;

public class AdjacentDups {
	//remove both characters if adjacent duplicates exist
	public static void main(String[] args) {
		String s = "abbacd";
		System.out.println("Original: " + s);
		
		String previous = "";
		String current = s;
		int step = 1;
		
		// Keep removing adjacent duplicates until no more changes
		while (!current.equals(previous)) {
			previous = current;
			StringBuilder s2 = new StringBuilder();
			
			for (int i = 0; i < current.length(); i++) {
				if((i == 0 || current.charAt(i) != current.charAt(i-1)) && 
				   (i == current.length() - 1 || current.charAt(i) != current.charAt(i+1))) {
					s2.append(current.charAt(i));
				}
			}
			current = s2.toString();
			
			if (!current.equals(previous)) {
				System.out.println("Step " + step + ": " + current);
				step++;
			}
		}
		
		System.out.println("Final result: " + current);
	}
}
