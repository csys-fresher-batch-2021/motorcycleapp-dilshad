package in.dilshad.model;

import java.util.HashMap;
import java.util.Map;

public class BikeDefault {
	public static HashMap<String, BikeSpecification> bikes = new HashMap<>();
	// Plate number - as key value

	static {
		// Sample bike 1
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
		engine1.put("vin", "AAA45DDDGGTTR3678");
		engine1.put("noPlate", "KA67A0000");

		bike1.engineDetails = engine1;

		// Sample bike 2
		BikeSpecification bike2 = new BikeSpecification();
		bike2.bikeManufacturer = "TVS";
		bike2.bikeModel = "Victor";
		bike2.bikeColor = "Silver";
		bike2.bikePrice = 25000;
		bike2.km = 91000;
		bike2.manufactureYear = 2011;
		bike2.status = false;

		Map<String, String> engine2 = new HashMap<>();
		engine2.put("fuelType", "Petrol");
		engine2.put("vin", "GKA45DDDGGTTR3670");
		engine2.put("noPlate", "TN67AS0900");
		bike2.engineDetails = engine2;

		// Sample bike 3
		BikeSpecification bike3 = new BikeSpecification();
		bike3.bikeManufacturer = "Hero Honda";
		bike3.bikeModel = "Passion Pro";
		bike3.bikeColor = "Red";
		bike3.bikePrice = 19000;
		bike3.km = 81000;
		bike3.manufactureYear = 2009;
		bike3.status = true;

		Map<String, String> engine3 = new HashMap<>();
		engine3.put("fuelType", "Petrol");
		engine3.put("vin", "GKA45DFDG9TSR3670");
		engine3.put("noPlate", "AP-67A8902");
		bike3.engineDetails = engine3;

		// Sample bike 4
		BikeSpecification bike4 = new BikeSpecification();
		bike4.bikeManufacturer = "Bajaj";
		bike4.bikeModel = "Chetak";
		bike4.bikeColor = "Blue";
		bike4.bikePrice = 20000;
		bike4.km = 30000;
		bike4.manufactureYear = 2014;
		bike4.status = false;

		Map<String, String> engine4 = new HashMap<>();
		engine4.put("fuelType", "Electric");
		engine4.put("vin", "GKA45OFD5PTSR3670");
		engine4.put("noPlate", "KL-67A1143");
		bike4.engineDetails = engine4;

		bikes.put(engine1.get("noPlate"), bike1);
		bikes.put(engine2.get("noPlate"), bike2);
		bikes.put(engine3.get("noPlate"), bike3);
		bikes.put(engine4.get("noPlate"), bike4);

	}

	/**
	 * Returns the Default bikes.
	 * 
	 * @return
	 */
	public static HashMap<String, BikeSpecification> getDefaultBikes() {
		return bikes;
	}
}
