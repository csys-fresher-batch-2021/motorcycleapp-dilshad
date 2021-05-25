package in.dilshad.validator;

import in.dilshad.util.StringValidator;

public class UserValidator {

	public static void isValidCredentials(String admin, String password) {
		if (!(isValidAdmin(admin) && isValidPassword(password)))
			throw new IllegalArgumentException("Enter Valid Credentials");
	}

	public static boolean isValidAdmin(String admin) {
		boolean isValid = false;
		if (StringValidator.isAlpha(admin))
			if (admin.equals("admin"))
				isValid = true;
		return isValid;
	}

	public static boolean isValidPassword(String password) {
		boolean isValid = false;
		if (StringValidator.isValidString(password))
			if (password.equals("admin!"))
				isValid = true;
		return isValid;
	}
}
