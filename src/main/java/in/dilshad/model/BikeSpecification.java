package in.dilshad.model;

import java.util.HashMap;
//Project title: Second-hand motorcycle buying, selling & renting
import java.util.Map;

public class BikeSpecification {

	public String bikeManufacturer;

	public String bikeModel;

	public String bikeColor;

	public float bikePrice;

	public int km;

	public int manufactureYear;

	public boolean status;

	public Map<String, String> engineDetails = new HashMap<>();

	@Override
	public String toString() {
		return "BikeSpecification [brand=" + bikeManufacturer + ", name=" + bikeModel + ", color=" + bikeColor
				+ ", price=" + bikePrice + ", km=" + km + ", year=" + manufactureYear + ", gear=" + status
				+ ", engineDetails=" + engineDetails + "]";
	}

}
