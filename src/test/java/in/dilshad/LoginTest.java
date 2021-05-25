package in.dilshad;

import static org.junit.Assert.*;

import org.junit.Test;

import in.dilshad.validator.UserValidator;
import junit.framework.Assert;

public class LoginTest {

	@Test
	public void adminIDTest() {
		String string1 = "admin";
		assertTrue(UserValidator.isValidAdmin(string1));
		
		String string2 = "user";
		assertFalse(UserValidator.isValidAdmin(string2));
		
		String string3 = "";
		assertFalse(UserValidator.isValidAdmin(string3));
		
		String string4 = "admin123";
		assertFalse(UserValidator.isValidAdmin(string4));
		
		String string5 = "admin%";
		assertFalse(UserValidator.isValidAdmin(string5));
	}
	
	@Test
	public void adminPassWordTest() {
		String string1 = "admin!";
		assertTrue(UserValidator.isValidPassword(string1));
		
		String string2 = "user";
		assertFalse(UserValidator.isValidPassword(string2));
		
		String string3 = "";
		assertFalse(UserValidator.isValidPassword(string3));
		
		String string4 = "admin123";
		assertFalse(UserValidator.isValidPassword(string4));
		
	}

}
