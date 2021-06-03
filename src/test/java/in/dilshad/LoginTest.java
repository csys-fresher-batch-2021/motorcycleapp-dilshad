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

		String string2 = "username";
		assertTrue(AdminValidator.isValidAdmin(string2));

		String string3 = "";
		assertFalse(AdminValidator.isValidAdmin(string3));


		String string4 = "admin%";
		assertFalse(AdminValidator.isValidAdmin(string4));
	}

	/**
	 * Password: Must not be null, can contain alphanumeric & special characters
	 * Default password is set as "admin!"
	 */
	@Test
	public void adminPassWordTest() {
		String string1 = "admin!";
		assertTrue(AdminValidator.isStrongPassword(string1));

		String string2 = "user";
		assertFalse(AdminValidator.isStrongPassword(string2));

		String string3 = "";
		assertFalse(AdminValidator.isStrongPassword(string3));

		String string4 = "admin123";
		assertTrue(AdminValidator.isStrongPassword(string4));

	}

}
