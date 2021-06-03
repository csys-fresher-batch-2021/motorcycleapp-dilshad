package in.dilshad;

import static org.junit.Assert.*;

import org.junit.Test;

import in.dilshad.validator.AdminValidator;

public class LoginTest {

	/**
	 * Admin Id : Must not be null. Default value is set as "admin"
	 */
	@Test
	public void adminIDTest() {
		String string1 = "admin";
		assertTrue(AdminValidator.isValidAdmin(string1));

		String string2 = "user";
		assertFalse(AdminValidator.isValidAdmin(string2));

		String string3 = "";
		assertFalse(AdminValidator.isValidAdmin(string3));

		String string4 = "admin123";
		assertFalse(AdminValidator.isValidAdmin(string4));

		String string5 = "admin%";
		assertFalse(AdminValidator.isValidAdmin(string5));
	}

	/**
	 * Password: Must not be null, can contain alphanumeric & special characters
	 * Default password is set as "admin!"
	 */
	@Test
	public void adminPassWordTest() {
		String string1 = "admin!";
		assertTrue(AdminValidator.isValidPassword(string1));

		String string2 = "user";
		assertFalse(AdminValidator.isValidPassword(string2));

		String string3 = "";
		assertFalse(AdminValidator.isValidPassword(string3));

		String string4 = "admin123";
		assertFalse(AdminValidator.isValidPassword(string4));

	}

}
