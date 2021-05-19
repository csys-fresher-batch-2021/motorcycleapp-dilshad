package in.dilshad.service;

import in.dilshad.model.*;

import java.util.HashMap;

import in.dilshad.model.BikeSpecification;

public class BikeManager {

	public static HashMap<String, BikeSpecification> bikes = BikeDefault.getDefaultBikes();
	/**
	 * Display the bikes available in show room
	 * Validation  is done while adding bikes.
	 */
	public static void displayBikes() {
		for (BikeSpecification bikelist : bikes.values())
			System.out.println(bikelist);

	}

}
