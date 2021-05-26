package in.dilshad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.dilshad.util.StringValidator;

public class StringValidatorTest {

	/**
	 * Check for valid string Condition: Must not be null and empty
	 */
	@Test
	public void stringValidationTest() {
		String string1 = "Motorcycle      ";
		assertTrue(StringValidator.isValidString(string1));

		String string2 = "Web page Development";
		assertTrue(StringValidator.isValidString(string2));

		String string3 = "  ";
		assertFalse(StringValidator.isValidString(string3));

		String string4 = null;
		assertFalse(StringValidator.isValidString(string4));
	}

	/**
	 * Check for presence of number in string Condition: Must have at lest one
	 * number
	 */
	@Test
	public void numberValidationTest() {
		String string1 = "Motorcycle";
		assertFalse(StringValidator.isNumberPresent(string1));

		String string2 = "Web page Development";
		assertFalse(StringValidator.isNumberPresent(string2));

		String string3 = "  ";
		assertFalse(StringValidator.isNumberPresent(string3));

		String string4 = null;
		assertFalse(StringValidator.isNumberPresent(string4));

		String string5 = "1804";
		assertTrue(StringValidator.isNumberPresent(string5));

		String string6 = "1,200";
		assertTrue(StringValidator.isNumberPresent(string6));
	}

	/**
	 * Check for presence of special character in string Condition: Must have at
	 * lest one special character
	 */
	@Test
	public void specialCharValidationTest() {
		String string1 = "Motorcycle";
		assertFalse(StringValidator.isSpecialCharPresent(string1));

		String string2 = "Web page Development$";
		assertTrue(StringValidator.isSpecialCharPresent(string2));

		String string3 = "  ";
		assertFalse(StringValidator.isSpecialCharPresent(string3));

		String string4 = null;
		assertFalse(StringValidator.isSpecialCharPresent(string4));

		String string5 = "1804";
		assertFalse(StringValidator.isSpecialCharPresent(string5));

		String string6 = "1,200";
		assertTrue(StringValidator.isSpecialCharPresent(string6));

	}

	/**
	 * Check for presence of alphabets only Condition: String must not contain
	 * special characters and numbers
	 */
	@Test
	public void isAlphaTest() {
		String string1 = "Motorcycle";
		assertTrue(StringValidator.isAlpha(string1));

		String string2 = "Web page Development$";
		assertFalse(StringValidator.isAlpha(string2));

		String string3 = "  ";
		assertFalse(StringValidator.isAlpha(string3));

		String string4 = null;
		assertFalse(StringValidator.isAlpha(string4));

		String string5 = "1804";
		assertFalse(StringValidator.isAlpha(string5));

		String string6 = "1,200";
		assertFalse(StringValidator.isAlpha(string6));
	}
}