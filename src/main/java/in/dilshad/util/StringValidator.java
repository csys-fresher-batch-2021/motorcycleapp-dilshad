package in.dilshad.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

	private StringValidator() {
		// Default constructor
	}

	/**
	 * Checks the presence of null character and whitespace
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean isValidString(String inputString) {
		boolean isValid = true;
		if (inputString == null || inputString.trim().isEmpty()) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Checks for the presence of Special Character.
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean isSpecialCharPresent(String inputString) {
		if (isValidString(inputString)) {
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9' ']");
			Matcher matcher = pattern.matcher(inputString.trim());
			return matcher.find();
		} else
			return false;
	}

	/**
	 * Checks the presence of numbers in the string
	 * 
	 * @param inputString
	 * @return
	 */
	public static boolean isNumberPresent(String inputString) {
		if (isValidString(inputString)) {
			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(inputString);
			return matcher.find();
		} else
			return false;
	}

	/**
	 * Checks the presence of Alphanumeric character only.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isAlpha(String input) {
		return !isSpecialCharPresent(input) && !isNumberPresent(input) && isValidString(input);
	}

}
