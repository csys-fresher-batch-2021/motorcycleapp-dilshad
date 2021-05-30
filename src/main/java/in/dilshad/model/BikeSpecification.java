package in.dilshad.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeSpecification {

	private String bikeManufacturer;

	private String bikeModel;

	private String bikeColor;

	private float bikePrice;

	private int km;

	private int manufactureYear;

	private boolean status;

	private Map<String, String> engineDetails = new HashMap<>();

}
