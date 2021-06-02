package in.dilshad;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import in.dilshad.service.BikeManager;

public class DisplayBikeTest {

	/**
	 * Checks whether display method throws exception.
	 */
	@Test
	public void displayBikeTest() {
		try {
			BikeManager.displayBikes();
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}

}
