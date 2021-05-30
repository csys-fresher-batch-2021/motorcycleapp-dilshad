/* To load some sample bikes into the database instantly when table is dropped 
or all bikes are removed. */

package in.dilshad.model;

import java.util.HashMap;
import java.util.Map;

import in.dilshad.dao.BikeDAO;
import in.dilshad.validator.BikeValidator;

public class DefaultBikes {
	private DefaultBikes() {

	}

	private static final Map<String, BikeSpecification> DefaultBikeMap = new HashMap<>();
	// Plate number - as key value
	private static final String FUEL = "fuelType";
	private static final String VIN = "vin";
	private static final String PLATE = "noPlate";

	static {
		// Sample bike 1
		BikeSpecification bike1 = new BikeSpecification();

		bike1.setBikeManufacturer("Hero");
		bike1.setBikeModel("Splendor");
		bike1.setBikeColor("blue");
		bike1.setBikePrice(10200);
		bike1.setKm(98078);
		bike1.setManufactureYear(2005);
		bike1.setStatus(false);

		Map<String, String> engine1 = new HashMap<>();
		engine1.put(FUEL, "Petrol");
		engine1.put(VIN, "AAA45DDDGGTTR3678");
		engine1.put(PLATE, "KA67A0000");
		bike1.setEngineDetails(engine1);

		try {
			BikeValidator.validateBikeSpecification(bike1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine1.get(PLATE), bike1);

		// Sample bike 2
		BikeSpecification bike2 = new BikeSpecification();

		bike2.setBikeManufacturer("TVS");
		bike2.setBikeModel("Victor");
		bike2.setBikeColor("Silver");
		bike2.setBikePrice(10000);
		bike2.setKm(91027);
		bike2.setManufactureYear(2005);
		bike2.setStatus(false);

		Map<String, String> engine2 = new HashMap<>();
		engine2.put(FUEL, "Petrol");
		engine2.put(VIN, "GKA45DDDGGTTR3670");
		engine2.put(PLATE, "TN67AS0900");
		bike2.setEngineDetails(engine2);

		try {
			BikeValidator.validateBikeSpecification(bike2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine2.get(PLATE), bike2);

		// Sample bike 3
		BikeSpecification bike3 = new BikeSpecification();

		bike3.setBikeManufacturer("Hero");
		bike3.setBikeModel("Passion Pro");
		bike3.setBikeColor("Red");
		bike3.setBikePrice(19000);
		bike3.setKm(81006);
		bike3.setManufactureYear(2009);
		bike3.setStatus(false);

		Map<String, String> engine3 = new HashMap<>();
		engine3.put(FUEL, "Petrol");
		engine3.put(VIN, "IKA45DFDG9TSR3670");
		engine3.put(PLATE, "AP67A8902");
		bike3.setEngineDetails(engine3);

		try {
			BikeValidator.validateBikeSpecification(bike3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine3.get(PLATE), bike3);

		// Sample bike 4
		BikeSpecification bike4 = new BikeSpecification();

		bike4.setBikeManufacturer("Bajaj");
		bike4.setBikeModel("Chetak");
		bike4.setBikeColor("Blue");
		bike4.setBikePrice(20723);
		bike4.setKm(40000);
		bike4.setManufactureYear(2009);
		bike4.setStatus(false);

		Map<String, String> engine4 = new HashMap<>();
		engine4.put(FUEL, "Electric");
		engine4.put(VIN, "ELA45OFD5PTSR3670");
		engine4.put(PLATE, "KL67A1143");
		bike4.setEngineDetails(engine4);

		try {
			BikeValidator.validateBikeSpecification(bike4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine4.get(PLATE), bike4);

		// Sample 5
		BikeSpecification bike5 = new BikeSpecification();

		bike5.setBikeManufacturer("Honda");
		bike5.setBikeModel("Activa");
		bike5.setBikeColor("Silver");
		bike5.setBikePrice(39000);
		bike5.setKm(56783);
		bike5.setManufactureYear(2003);
		bike5.setStatus(true);

		Map<String, String> engine5 = new HashMap<>();
		engine5.put(FUEL, "Petrol");
		engine5.put(VIN, "IKA235DFDG9BCR367");
		engine5.put(PLATE, "TN89V3489");
		bike5.setEngineDetails(engine5);

		try {
			BikeValidator.validateBikeSpecification(bike5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine5.get(PLATE), bike5);

		// Sample 6
		BikeSpecification bike6 = new BikeSpecification();

		bike6.setBikeManufacturer("Hero");
		bike6.setBikeModel("Electric Optima LA");
		bike6.setBikeColor("Red");
		bike6.setBikePrice(29000);
		bike6.setKm(56783);
		bike6.setManufactureYear(2008);
		bike6.setStatus(true);

		Map<String, String> engine6 = new HashMap<>();
		engine6.put(FUEL, "Electric");
		engine6.put(VIN, "IKA2CV78DG9BCV609");
		engine6.put(PLATE, "AP89V3489");
		bike6.setEngineDetails(engine6);

		try {
			BikeValidator.validateBikeSpecification(bike6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine6.get(PLATE), bike6);

		// Sample 7
		BikeSpecification bike7 = new BikeSpecification();

		bike7.setBikeManufacturer("TVS");
		bike7.setBikeModel("iQube");
		bike7.setBikeColor("White");
		bike7.setBikePrice(79000);
		bike7.setKm(45783);
		bike7.setManufactureYear(2016);
		bike7.setStatus(true);

		Map<String, String> engine7 = new HashMap<>();
		engine7.put(FUEL, "Electric");
		engine7.put(VIN, "VB567BFERG9BCV607");
		engine7.put(PLATE, "DL89V3000");
		bike7.setEngineDetails(engine7);

		try {
			BikeValidator.validateBikeSpecification(bike7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine7.get(PLATE), bike7);

		// Sample 8
		BikeSpecification bike8 = new BikeSpecification();

		bike8.setBikeManufacturer("Royal Enfield");
		bike8.setBikeModel("Bullet350");
		bike8.setBikeColor("Light green");
		bike8.setBikePrice(87000);
		bike8.setKm(78781);
		bike8.setManufactureYear(1998);
		bike8.setStatus(false);

		Map<String, String> engine8 = new HashMap<>();
		engine8.put(FUEL, "Petrol");
		engine8.put(VIN, "CV345GHJU67UYG459");
		engine8.put(PLATE, "TN78OP3489");
		bike8.setEngineDetails(engine8);

		try {
			BikeValidator.validateBikeSpecification(bike8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine8.get(PLATE), bike8);

		// Sample 9
		BikeSpecification bike9 = new BikeSpecification();

		bike9.setBikeManufacturer("TVS");
		bike9.setBikeModel("Sports");
		bike9.setBikeColor("Gray");
		bike9.setBikePrice(19500);
		bike9.setKm(34783);
		bike9.setManufactureYear(2011);
		bike9.setStatus(true);

		Map<String, String> engine9 = new HashMap<>();
		engine9.put(FUEL, "Petrol");
		engine9.put(VIN, "BNMJ890L6R9BCV607");
		engine9.put(PLATE, "KL89V3984");
		bike9.setEngineDetails(engine9);

		try {
			BikeValidator.validateBikeSpecification(bike9);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine9.get(PLATE), bike9);

		// Sample 10
		BikeSpecification bike10 = new BikeSpecification();

		bike10.setBikeManufacturer("Bajaj");
		bike10.setBikeModel("Pulsar125");
		bike10.setBikeColor("Black");
		bike10.setBikePrice(29500);
		bike10.setKm(34983);
		bike10.setManufactureYear(2010);
		bike10.setStatus(true);

		Map<String, String> engine10 = new HashMap<>();
		engine10.put(FUEL, "Petrol");
		engine10.put(VIN, "MOI89J8L6R9BCV607");
		engine10.put(PLATE, "AP89V3761");
		bike10.setEngineDetails(engine10);

		try {
			BikeValidator.validateBikeSpecification(bike10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultBikeMap.put(engine10.get(PLATE), bike10);
	}

	public static void main(String[] args) {
		Map<String, BikeSpecification> bikeList = DefaultBikeMap;
		int i = 0;
		for (BikeSpecification bike : bikeList.values()) {
			//BikeDAO.addBike(bike);
			System.out.println(bike);
			i++;
		}
		System.err.println("Count = " + i);
	}
}
