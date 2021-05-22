package in.dilshad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;

public class SearchBikeTest {
	BikeSpecification BikeSpecification = new BikeSpecification();
	Map<String, BikeSpecification> bikeList = BikeManager.getAllBikes();

	@Test
	public void searchTest1() {
		String plateNo = "TN67AS0900";
		try {
			bikeList.get(plateNo);
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(false);
		}
	}

	@Test
	public void searchTest2() {
		String plateNo = "TN67AS0911";
		try {
			bikeList.get(plateNo);
			assertFalse(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
