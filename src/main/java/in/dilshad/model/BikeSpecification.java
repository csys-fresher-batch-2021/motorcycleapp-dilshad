package in.dilshad.model;

import java.util.HashMap;
//Project title: Second-hand motorcycle buying, selling & renting
import java.util.Map;

public class BikeSpecification {

	public BikeSpecification() {
		super();
		// Default constructor
	}

	private String bikeManufacturer;

	private String bikeModel;

	private String bikeColor;

	private float bikePrice;

	private int km;

	private int manufactureYear;

	private boolean status;

	private Map<String, String> engineDetails = new HashMap<>();

	/**
	 * @return the bikeManufacturer
	 */
	public String getBikeManufacturer() {
		return bikeManufacturer;
	}

	/**
	 * @param bikeManufacturer the bikeManufacturer to set
	 */
	public void setBikeManufacturer(String bikeManufacturer) {
		this.bikeManufacturer = bikeManufacturer;
	}

	/**
	 * @return the bikeModel
	 */
	public String getBikeModel() {
		return bikeModel;
	}

	/**
	 * @param bikeModel the bikeModel to set
	 */
	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	/**
	 * @return the bikeColor
	 */
	public String getBikeColor() {
		return bikeColor;
	}

	/**
	 * @param bikeColor the bikeColor to set
	 */
	public void setBikeColor(String bikeColor) {
		this.bikeColor = bikeColor;
	}

	/**
	 * @return the bikePrice
	 */
	public float getBikePrice() {
		return bikePrice;
	}

	/**
	 * @param bikePrice the bikePrice to set
	 */
	public void setBikePrice(float bikePrice) {
		this.bikePrice = bikePrice;
	}

	/**
	 * @return the km
	 */
	public int getKm() {
		return km;
	}

	/**
	 * @param km the km to set
	 */
	public void setKm(int km) {
		this.km = km;
	}

	/**
	 * @return the manufactureYear
	 */
	public int getManufactureYear() {
		return manufactureYear;
	}

	/**
	 * @param manufactureYear the manufactureYear to set
	 */
	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the engineDetails
	 */
	public Map<String, String> getEngineDetails() {
		return engineDetails;
	}

	/**
	 * @param engineDetails the engineDetails to set
	 */
	public void setEngineDetails(Map<String, String> engineDetails) {
		this.engineDetails = engineDetails;
	}

	@Override
	public String toString() {
		return "BikeSpecification [brand=" + bikeManufacturer + ", name=" + bikeModel + ", color=" + bikeColor
				+ ", price=" + bikePrice + ", km=" + km + ", year=" + manufactureYear + ", gear=" + status
				+ ", engineDetails=" + engineDetails + "]";
	}

}
