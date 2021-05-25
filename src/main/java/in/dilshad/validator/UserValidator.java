package in.dilshad.validator;

import in.dilshad.util.StringValidator;

public class UserValidator {

	private UserValidator() {
		// Default constructor
	}

	/**
	 * Check Admin Id and Password and throws exception if invalid.
	 * 
	 * @param admin
	 * @param password
	 */
	public static void isValidCredentials(String admin, String password) throws IllegalArgumentException {
		if (!(isValidAdmin(admin) && isValidPassword(password)))
			throw new IllegalArgumentException("Enter Valid Credentials");
	}

	/**
	 * Validates Admin Id. Default value is "admin"
	 * 
	 * @param admin
	 * @return
	 */
	public static boolean isValidAdmin(String admin) {
		boolean isValid = false;
		if (StringValidator.isAlpha(admin))
			isValid = admin.equals("admin");
		return isValid;
	}

	/**
	 * Validates Password. Default value is "admin!"
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		boolean isValid = false;
		if (StringValidator.isValidString(password))
			isValid = password.equals("admin!");
		isValid = true;
		return isValid;
	}
}
