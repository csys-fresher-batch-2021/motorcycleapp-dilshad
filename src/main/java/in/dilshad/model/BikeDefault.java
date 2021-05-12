package in.dilshad.model;

	import java.util.HashMap;

	public class BikeDefault {
		public static HashMap<String, BikeSpecification> bikes = new HashMap<String, BikeSpecification>();
		//Plate number - as key value
		
		static {
			// Sample 1	
			BikeSpecification bike1 = new BikeSpecification();
				
				bike1.brand = "Hero Honda";
				bike1.name = "Splendor";
				bike1.color = "blue";
				bike1.price = 30000;
				bike1.km = 96000;
				bike1.year = 2005;
				bike1.gear = true;
				
				HashMap<String, String> engine1 = new HashMap<String,String>();
				engine1.put("engineNo", "A2we34");
				engine1.put("vin","33452323");
				engine1.put("noPlate","TN-67A0000");
				
				bike1.engineDetails = engine1;
				
			//Sample 2	
			BikeSpecification bike2 = new BikeSpecification();
				bike2.brand = "TVS";
				bike2.name = "Victor";
				bike2.color = "Silver";
				bike2.price = 25000;
				bike2.km = 91000;
				bike2.year = 2011;
				bike2.gear = true;
				
				HashMap<String, String> engine2 = new HashMap<String,String>();
				engine2.put("engineNo", "A2eo34");
				engine2.put("vin","3345453");
				engine2.put("noPlate","TN-67A0001");
				
				bike2.engineDetails = engine2;
			
				bikes.put(engine1.get("noPlate") , bike1);
				bikes.put(engine2.get("noPlate") , bike2);

				bikes.put(engine1.get("noPlate") , bike1);
				bikes.put(engine2.get("noPlate") , bike2);
				
		}
		
		public static HashMap<String, BikeSpecification> getDefaultBikes() {
			return bikes;
		}
	}

