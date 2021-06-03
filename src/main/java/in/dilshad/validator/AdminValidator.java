package in.dilshad.validator;

import in.dilshad.exception.ValidationException;
import in.dilshad.model.AdminDetails;
import in.dilshad.util.StringValidator;

public class AdminValidator {

	private AdminValidator() {
		// Default constructor
	}

	/**
	 * Check Admin Id and Password and throws exception if invalid.
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

	public static boolean isValidName(String name) {
		return StringValidator.isAlpha(name);
	}

	/**
	 * Validates Admin Id. Default value is "admin"
	 * 
	 * @param admin
	 * @return
	 */
	public static boolean isValidAdmin(String Id) {
		boolean isValid = false;
		if (StringValidator.isValidString(Id, 15) && !StringValidator.isSpecialCharPresent(Id))
			isValid = true;
		return isValid;
	}

	public static boolean isStrongPassword(String password) {
		return StringValidator.isValidString(password, 20, 5);
	}

}
