package src.Strings;

public class Assignment {
	// check for valid e mails
	public static boolean isValidEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(emailRegex);
	}
	
	public static void main(String[] args) {

		System.out.println(isValidEmail("test@example.com")); // true
		System.out.println(isValidEmail("user.name@domain.co.in")); // true
		System.out.println(isValidEmail("invalid.email@")); // false
		System.out.println(isValidEmail("@invalid.com")); // false
	}
}
