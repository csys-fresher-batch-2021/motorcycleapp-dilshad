package in.dilshad;

import org.junit.Test;

import in.dilshad.service.BikeManager;

public class PrimaryTest {

	/**
	 * To display default bikes available in show room
	 */
	@Test
	public void dilspayDefaultBikes() {
		try {
			BikeManager.displayBikes();
		} catch (Exception e) {
			System.out.println("Not displayed");
		}
	}

}
