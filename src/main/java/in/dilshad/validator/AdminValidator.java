package in.dilshad.validator;

import in.dilshad.exception.ValidationException;
import in.dilshad.model.AdminDetails;
import in.dilshad.util.StringValidator;

public class AdminValidator {

	private AdminValidator() {
		// Default constructor
	}

	/**
	 * Check admin name,admin Id & Password and throws exception if invalid.
	 * 
	 * @param admin
	 * @param password
	 * @throws ValidationException
	 */
	public static void validateRegister(AdminDetails admin) throws IllegalArgumentException, ValidationException {
		String name = admin.getName();
		String id = admin.getID();
		String password = admin.getPassword();
		if (!(isValidAdmin(id) && isStrongPassword(password) && isValidName(name)))
			throw new ValidationException("Registration unsuccessful");
	}

	/**
	 * Checks if admin name consist of only alphabets and the lenght ranges from 2
	 * to 20 characters.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isValidName(String name) {
		return StringValidator.isAlpha(name) && StringValidator.isValidString(name, 20, 2);
	}

	/**
	 * Validates Admin id. Length must be in the range 2 to 15 characters. Special
	 * characters should not be present.
	 * 
	 * @param admin
	 * @return
	 */
	public static boolean isValidAdmin(String Id) {
		boolean isValid = false;
		if (StringValidator.isValidString(Id, 15, 2) && !StringValidator.isSpecialCharPresent(Id))
			isValid = true;
		return isValid;
	}

	/**
	 * Checks if the password length is between 5 and 20 characters.
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isStrongPassword(String password) {
		return StringValidator.isValidString(password, 20, 5);
	}

}
