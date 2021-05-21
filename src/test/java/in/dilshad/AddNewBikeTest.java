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
		bike1.setBikeManufacturer("Hero Honda");
		bike1.setBikeModel("Splendor");
		bike1.setBikeColor("blue");
		bike1.setBikePrice(10000);
		bike1.setKm(98000);
		bike1.setManufactureYear(2005);
		bike1.setStatus(false);
		Map<String, String> engine1 = new HashMap<>();
		engine1.put("fuelType", "Petrol");
		engine1.put("vin", "AAA45DDDGGTTR3678");
		engine1.put("noPlate", "KA67A0000");
		bike1.setEngineDetails(engine1);
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
		BikeSpecification bike2 = new BikeSpecification();
		bike2.setBikeManufacturer("Hero*Honda");
		bike2.setBikeModel("Splendor");
		bike2.setBikeColor("blue");
		bike2.setBikePrice(10000);
		bike2.setKm(98000);
		bike2.setManufactureYear(2005);
		bike2.setStatus(false);
		Map<String, String> engine2 = new HashMap<>();
		engine2.put("fuelType", "Petrol");
		engine2.put("vin", "AAA45DDDGGTTR3678");
		engine2.put("noPlate", "KA67A0000");
		bike2.setEngineDetails(engine2);
		try {
			BikeManager.addBike(bike2);
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
		BikeSpecification bike3 = new BikeSpecification();
		bike3.setBikeManufacturer("Hero Honda");
		bike3.setBikeModel("Splendor");
		bike3.setBikeColor("blue");
		bike3.setBikePrice(40000000);
		bike3.setKm(98000);
		bike3.setManufactureYear(2005);
		bike3.setStatus(false);
		Map<String, String> engine3 = new HashMap<>();
		engine3.put("fuelType", "Petrol");
		engine3.put("vin", "AAA45DDDGGTTR3678");
		engine3.put("noPlate", "KA67A0000");
		bike3.setEngineDetails(engine3);
		try {
			BikeManager.addBike(bike3);
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
		BikeSpecification bike4 = new BikeSpecification();
		bike4.setBikeManufacturer("Hero Honda");
		bike4.setBikeModel("Splendor");
		bike4.setBikeColor("blue");
		bike4.setBikePrice(40000);
		bike4.setKm(-98000);
		bike4.setManufactureYear(2005);
		bike4.setStatus(false);
		Map<String, String> engine4 = new HashMap<>();
		engine4.put("fuelType", "Petrol");
		engine4.put("vin", "AAA45DDDGGTTR3678");
		engine4.put("noPlate", "KA67A0000");
		bike4.setEngineDetails(engine4);
		try {
			BikeManager.addBike(bike4);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Introducing error: Bike Year of manufacture 2030
	 */
	@Test
	public void addBikeTest5() {
		BikeSpecification bike5 = new BikeSpecification();
		bike5.setBikeManufacturer("Hero Honda");
		bike5.setBikeModel("Splendor");
		bike5.setBikeColor("blue");
		bike5.setBikePrice(40000);
		bike5.setKm(98000);
		bike5.setManufactureYear(2030);
		bike5.setStatus(false);
		Map<String, String> engine5 = new HashMap<>();
		engine5.put("fuelType", "Petrol");
		engine5.put("vin", "AAA45DDDGGTTR3678");
		engine5.put("noPlate", "KA67A0000");
		bike5.setEngineDetails(engine5);
		try {
			BikeManager.addBike(bike5);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Introducing error: White space in VIN and not in proper format
	 */
	@Test
	public void addBikeTest6() {
		BikeSpecification bike6 = new BikeSpecification();
		bike6.setBikeManufacturer("Hero Honda");
		bike6.setBikeModel("Splendor");
		bike6.setBikeColor("blue");
		bike6.setBikePrice(40000);
		bike6.setKm(98000);
		bike6.setManufactureYear(2007);
		bike6.setStatus(false);
		Map<String, String> engine6 = new HashMap<>();
		engine6.put("fuelType", "Petrol");
		engine6.put("vin", "AAA4 DGG TR3678");
		engine6.put("noPlate", "KA67A0000");
		bike6.setEngineDetails(engine6);
		try {
			BikeManager.addBike(bike6);
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
		BikeSpecification bike7 = new BikeSpecification();
		bike7.setBikeManufacturer("Hero Honda");
		bike7.setBikeModel("Splendor");
		bike7.setBikeColor("blue");
		bike7.setBikePrice(40000);
		bike7.setKm(98000);
		bike7.setManufactureYear(2007);
		bike7.setStatus(false);
		Map<String, String> engine7 = new HashMap<>();
		engine7.put("fuelType", "Petrol");
		engine7.put("vin", "AAA45DDDGGTTR3678");
		engine7.put("noPlate", "KAE90A23O9");
		bike7.setEngineDetails(engine7);
		try {
			BikeManager.addBike(bike7);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}
