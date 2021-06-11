/**
 * 
 */
package in.dilshad;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.dilshad.validator.OwnerValidator;

/**
 * @author dils2654
 *
 */
class OwnerDetailsTest {

	@Test
	void mobileNoTest() {
		Long number1 = 9087657867L;
		assertTrue(OwnerValidator.isValidPhoneNo(number1));
		
		Long number2 = 908765786L;
		assertFalse(OwnerValidator.isValidPhoneNo(number2));
		
		Long number3 = 5087657867L;
		assertFalse(OwnerValidator.isValidPhoneNo(number3));
		
		Long number4 = 8087657867L;
		assertTrue(OwnerValidator.isValidPhoneNo(number4));
		
		Long number5 = 70876578672L;
		assertFalse(OwnerValidator.isValidPhoneNo(number5));
	}
	
	@Test
	void ownerNameTest() {
		String name1 = "Ganesh";
		assertTrue(OwnerValidator.isValidName(name1));
		
		String name2 = "a";
		assertFalse(OwnerValidator.isValidName(name2));
		
		String name3 = "Ganesh Raja Pandian Jeya Lakshmi";
		assertFalse(OwnerValidator.isValidName(name3));
	}
	
	@Test
	void ownerAddressTest() {
		String address1 = "74, Gnanagiri Road (near Coronation School), Sivakasi 626189.";
		assertTrue(OwnerValidator.isValidAddress(address1));
		
		String address2 = "74";
		assertFalse(OwnerValidator.isValidAddress(address2));
		
		String address3 = "23, South car street , Sivakasi 626189";
		assertTrue(OwnerValidator.isValidAddress(address3));
	}

}
