package in.dilshad.service;

import java.util.HashMap;
import java.util.Map;

import in.dilshad.model.BikeDefault;
import in.dilshad.model.BikeSpecification;
import in.dilshad.validator.BikeValidator;

public class BikeManager {

	private static Map<String, BikeSpecification> bikes = BikeDefault.getDefaultBikes();

	/**
	 * To get all list of bikes stored in Hash Map
	 * 
	 * @return
	 */
	public static Map<String, BikeSpecification> getAllBikes() {
		return bikes;
	}

	/**
	 * Display the bikes available in show room
	 */
	public static void displayBikes() {
		for (BikeSpecification bikelist : bikes.values())
			System.out.println(bikelist);
	}

	/**
	 * Adding the new bike to the Hash Map. Validation is done followed by addition.
	 * Exception is handled and exception message is forwarded.
	 * 
	 * @param newBike
	 */
	public static void addBike(BikeSpecification newBike) {
		try {
			BikeValidator.validateBikeSpecification(newBike);
			String key = newBike.engineDetails.get("noPlate");
			bikes.put(key, newBike);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
