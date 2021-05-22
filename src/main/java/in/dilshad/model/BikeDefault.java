package in.dilshad.model;

import java.util.HashMap;
import java.util.Map;

public class BikeDefault {
	private BikeDefault() {

	}

	private static final Map<String, BikeSpecification> DefaultBikeMap = new HashMap<>();
	// Plate number - as key value
	private static final String FUEL = "fuelType";
	private static final String VIN = "vin";
	private static final String PLATE = "noPlate";

	static {
		// Sample bike 1
		BikeSpecification bike1 = new BikeSpecification();

		bike1.setBikeManufacturer("Hero Honda");
		bike1.setBikeModel("Splendor");
		bike1.setBikeColor("blue");
		bike1.setBikePrice(10000);
		bike1.setKm(98000);
		bike1.setManufactureYear(2005);
		bike1.setStatus(false);

		Map<String, String> engine1 = new HashMap<>();
		engine1.put(FUEL, "Petrol");
		engine1.put(VIN, "AAA45DDDGGTTR3678");
		engine1.put(PLATE, "KA67A0000");
		bike1.setEngineDetails(engine1);

		// Sample bike 2
		BikeSpecification bike2 = new BikeSpecification();

		bike2.setBikeManufacturer("TVS");
		bike2.setBikeModel("Victor");
		bike2.setBikeColor("Silver");
		bike2.setBikePrice(10000);
		bike2.setKm(91000);
		bike2.setManufactureYear(2005);
		bike2.setStatus(false);

		Map<String, String> engine2 = new HashMap<>();
		engine2.put(FUEL, "Petrol");
		engine2.put(VIN, "GKA45DDDGGTTR3670");
		engine2.put(PLATE, "TN67AS0900");
		bike2.setEngineDetails(engine2);

		// Sample bike 3
		BikeSpecification bike3 = new BikeSpecification();

		bike3.setBikeManufacturer("Hero Honda");
		bike3.setBikeModel("Passion Pro");
		bike3.setBikeColor("Red");
		bike3.setBikePrice(19000);
		bike3.setKm(81000);
		bike3.setManufactureYear(2009);
		bike3.setStatus(false);

		Map<String, String> engine3 = new HashMap<>();
		engine3.put(FUEL, "Petrol");
		engine3.put(VIN, "IKA45DFDG9TSR3670");
		engine3.put(PLATE, "AP67A8902");
		bike3.setEngineDetails(engine3);

		// Sample bike 4
		BikeSpecification bike4 = new BikeSpecification();

		bike4.setBikeManufacturer("Bajaj");
		bike4.setBikeModel("Chetak");
		bike4.setBikeColor("Blue");
		bike4.setBikePrice(20000);
		bike4.setKm(30000);
		bike4.setManufactureYear(2009);
		bike4.setStatus(false);

		Map<String, String> engine4 = new HashMap<>();
		engine4.put(FUEL, "Electric");
		engine4.put(VIN, "ELA45OFD5PTSR3670");
		engine4.put(PLATE, "KL67A1143");
		bike4.setEngineDetails(engine4);

		DefaultBikeMap.put(engine1.get(PLATE), bike1);
		DefaultBikeMap.put(engine2.get(PLATE), bike2);
		DefaultBikeMap.put(engine3.get(PLATE), bike3);
		DefaultBikeMap.put(engine4.get(PLATE), bike4);

	}

	/**
	 * Returns the Default bikes.
	 * 
	 * @return
	 */
	public static Map<String, BikeSpecification> getDefaultBikes() {
		return DefaultBikeMap;
	}

}
