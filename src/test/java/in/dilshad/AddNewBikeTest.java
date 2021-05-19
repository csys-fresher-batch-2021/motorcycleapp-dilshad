/**
 * 
 */
package in.dilshad;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;

/**
 * @author dils2654
 *
 */
public class AddNewBikeTest {
	
	/*
	 * Correct details
	 */
	@Test
	public void addBikeTest1() {
				BikeSpecification bike1 = new BikeSpecification();

				bike1.bikeManufacturer = "Hero Honda";
				bike1.bikeModel = "Splendor";
				bike1.bikeColor = "blue";
				bike1.bikePrice = 30000;
				bike1.km = 96000;
				bike1.manufactureYear = 2005;
				bike1.status = true;

				Map<String, String> engine1 = new HashMap<>();
				engine1.put("fuelType", "Petrol");
				engine1.put("vin", "AAAADDDDGGTTR3678");
				engine1.put("noPlate", "TN67A0000");
				bike1.engineDetails = engine1;
		try {
			BikeManager.addBike(bike1);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	/**
	 * Introducing error: Special characters in bikeManufacturer field
	 */
	@Test
	public void addBikeTest2() {
				BikeSpecification bike1 = new BikeSpecification();

				bike1.bikeManufacturer = "Hero$Honda";
				bike1.bikeModel = "Splendor";
				bike1.bikeColor = "blue";
				bike1.bikePrice = 30000;
				bike1.km = 96000;
				bike1.manufactureYear = 2005;
				bike1.status = true;

				Map<String, String> engine1 = new HashMap<>();
				engine1.put("fuelType", "Petrol");
				engine1.put("vin", "AAAA5DDDGGTTR3678");
				engine1.put("noPlate", "TN67A0000");
				bike1.engineDetails = engine1;
		try {
			BikeManager.addBike(bike1);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	/**
	 * Introducing error: Bike Price greater that 3 Lakhs
	 */
	@Test
	public void addBikeTest3() {
				BikeSpecification bike1 = new BikeSpecification();

				bike1.bikeManufacturer = "Hero Honda";
				bike1.bikeModel = "Splendor";
				bike1.bikeColor = "blue";
				bike1.bikePrice = 300000000;
				bike1.km = 96000;
				bike1.manufactureYear = 2005;
				bike1.status = true;

				Map<String, String> engine1 = new HashMap<>();
				engine1.put("fuelType", "Petrol");
				engine1.put("vin", "AAAADDDDGGTTR3678");
				engine1.put("noPlate", "TN67A0000");
				bike1.engineDetails = engine1;
		try {
			BikeManager.addBike(bike1);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Introducing error: Odometer reading - negative number
	 */
	@Test
	public void addBikeTest4() {
				BikeSpecification bike1 = new BikeSpecification();

				bike1.bikeManufacturer = "Hero Honda";
				bike1.bikeModel = "Splendor";
				bike1.bikeColor = "blue";
				bike1.bikePrice = 30000;
				bike1.km = -96000;
				bike1.manufactureYear = 2005;
				bike1.status = true;

				Map<String, String> engine1 = new HashMap<>();
				engine1.put("fuelType", "Petrol");
				engine1.put("vin", "AAAADDDDGGTTR3678");
				engine1.put("noPlate", "TN67A0000");
				bike1.engineDetails = engine1;
		try {
			BikeManager.addBike(bike1);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Introducing error: Bike Year of manufacture 2030
	 */
	@Test
	public void addBikeTest6() {
				BikeSpecification bike1 = new BikeSpecification();

				bike1.bikeManufacturer = "Hero Honda";
				bike1.bikeModel = "Splendor";
				bike1.bikeColor = "blue";
				bike1.bikePrice = 30000;
				bike1.km = 96000;
				bike1.manufactureYear = 2030;
				bike1.status = true;

				Map<String, String> engine1 = new HashMap<>();
				engine1.put("fuelType", "Petrol");
				engine1.put("vin", "AAAADDDDGGTTR3678");
				engine1.put("noPlate", "TN67A0000");
				bike1.engineDetails = engine1;
		try {
			BikeManager.addBike(bike1);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	/**
	 * Introducing error: White space in VIN and not in proper format
	 */
	@Test
	public void addBikeTest7() {
				BikeSpecification bike1 = new BikeSpecification();

				bike1.bikeManufacturer = "Hero Honda";
				bike1.bikeModel = "Splendor";
				bike1.bikeColor = "blue";
				bike1.bikePrice = 30000;
				bike1.km = 96000;
				bike1.manufactureYear = 2005;
				bike1.status = true;

				Map<String, String> engine1 = new HashMap<>();
				engine1.put("fuelType", "Petrol");
				engine1.put("vin", "AAAADDD  TR3678");
				engine1.put("noPlate", "TN67A0000");
				bike1.engineDetails = engine1;
		try {
			BikeManager.addBike(bike1);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Introducing error: Plate number not in correct format
	 */
	@Test
	public void addBikeTest8() {
				BikeSpecification bike1 = new BikeSpecification();

				bike1.bikeManufacturer = "Hero Honda";
				bike1.bikeModel = "Splendor";
				bike1.bikeColor = "blue";
				bike1.bikePrice = 30000;
				bike1.km = 96000;
				bike1.manufactureYear = 2005;
				bike1.status = true;

				Map<String, String> engine1 = new HashMap<>();
				engine1.put("fuelType", "Petrol");
				engine1.put("vin", "AAAADDDDGGTTR3678");
				engine1.put("noPlate", "TN6V7A000D0");
				bike1.engineDetails = engine1;
		try {
			BikeManager.addBike(bike1);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}


}
