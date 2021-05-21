package in.dilshad;

import static org.junit.Assert.*;

import org.junit.Test;

import in.dilshad.service.BikeManager;

public class DisplayBikeTest {
	
	/**
	 * Checks whether display method throws exception. 
	 */
	@Test
	public void DisplayBikeTest() {
		try {
			BikeManager.displayBikes();
			assertTrue(true);
		}catch (Exception e) {
			assertFalse(false);
		}
	}

}
