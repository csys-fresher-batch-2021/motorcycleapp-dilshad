package in.dilshad.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.dilshad.model.BikeSpecification;
import in.dilshad.service.BikeManager;
import in.dilshad.util.StringValidator;

public class BikeValidator {

	private BikeValidator() {
		// to avoid object creation
	}

	static List<String> errorList = new ArrayList<>();

	/**
	 * This method checks the Bike Specification fields. Throws exception when any
	 * one of the Bike Specification goes wrong.
	 * 
	 * @param newBike
	 * @throws IllegalArgumentException
	 */
	public static void validateBikeSpecification(BikeSpecification newBike) throws IllegalArgumentException {
		if (!isValidBikeManufacturer(newBike.getBikeManufacturer()))
			errorList.add("Enter Valid Bike Manufacturer");

		if (!isValidBikeModel(newBike.getBikeModel()))
			errorList.add("Enter Valid Bike Model");

		if (!BikeValidator.isValidBikeColor(newBike.getBikeColor()))
			errorList.add("Enter Valid Bike Color");

		if (!BikeValidator.isValidKm(newBike.getKm()))
			errorList.add("Enter Valid Oddometer Reading");

		if (!BikeValidator.isValidManufactureYear(newBike.getManufactureYear()))
			errorList.add("Enter Valid Bike Manufacture Year");

		if (!isValidVin(newBike.getEngineDetails().get("vin")))
			errorList.add("Enter Valid VIN");

		if (!isValidPlateNumber(newBike.getEngineDetails().get("noPlate")))
			errorList.add("Enter Valid Plate number");

		if (!isValidBikePrice(newBike.getBikePrice()))
			errorList.add("Enter Valid Bike Price");

		validateUniqueFeatures(newBike.getEngineDetails().get("noPlate"), newBike.getEngineDetails().get("vin"));

		if (!errorList.isEmpty()) {
			String errorMessage = String.join(",", errorList);
			throw new IllegalArgumentException(errorMessage);
		}

	}

	/**
	 * Validates the name of Bike Manufacturer Checks the presence of Alphanumeric
	 * character
	 * 
	 * @param BikeManufacturer
	 * @return
	 */
	public static boolean isValidBikeManufacturer(String BikeManufacturer) {
		return StringValidator.isAlpha(BikeManufacturer);
	}

	/**
	 * Validates the name of Bike Model Checks the presence of Alphanumeric
	 * character
	 * 
	 * @param BikeModel
	 * @return
	 */
	public static boolean isValidBikeModel(String BikeModel) {
		return (StringValidator.isValidString(BikeModel) && !StringValidator.isSpecialCharPresent(BikeModel));
	}

	/**
	 * Validates the name of Bike Color Checks the presence of Alphanumeric
	 * character
	 * 
	 * @param BikeColor
	 * @return
	 */
	public static boolean isValidBikeColor(String BikeColor) {
		return StringValidator.isAlpha(BikeColor);
	}

	/**
	 * Checks the Pattern of Number plate
	 * 
	 * @param noPlate
	 * @return
	 */
	public static boolean isValidPlateNumber(String noPlate) {
		boolean isValid = false;
		if (StringValidator.isValidString(noPlate.trim()))
			isValid = Pattern.matches("[A-Z]{2}[0-9]{2}[A-Z]{1,3}[0-9]{4}", noPlate);
		return isValid;
	}

	/**
	 * Validates the Year of Manufacture of Bike
	 * 
	 * @param manufactureYear
	 * @return
	 */
	public static boolean isValidManufactureYear(int manufactureYear) {
		boolean isValid = false;
		Date d = new Date();
		int year = d.getYear();
		int currentYear = year + 1900;
		if (manufactureYear <= currentYear && manufactureYear > 1900)
			isValid = true;
		return isValid;
	}

	/**
	 * Validates the Odometer reading
	 * 
	 * @param km
	 * @return
	 */
	public static boolean isValidKm(int km) {
		boolean isValid = false;
		if (km > 0 && km < 500000)
			isValid = true;
		return isValid;
	}

	/**
	 * Validates the Price of the bike
	 * 
	 * @param bikePrice
	 * @return
	 */
	public static boolean isValidBikePrice(float bikePrice) {
		boolean isValid = false;
		if (bikePrice > 0 && bikePrice < 300000)
			isValid = true;
		return isValid;
	}

	/**
	 * Validates Vehicle Identification Number Checks the presence of Alphanumeric
	 * characters and String length
	 * 
	 * @param vin
	 * @return
	 */
	public static boolean isValidVin(String vin) {
		boolean isValid = false;
		if (StringValidator.isValidString(vin.trim())) {
			Pattern pattern = Pattern.compile("[A-Z0-9]{17}");
			Matcher matcher = pattern.matcher(vin);
			isValid = matcher.find();
		}
		return isValid;
	}

	/**
	 * This method checks that the Plate no and VIN of newly added bike - is not
	 * present in the existing bikes. It ensures the unique property of Plate no and
	 * VIN.
	 * 
	 * @param bike
	 * @return
	 */
	public static void validateUniqueFeatures(String noPlate, String vin) {
		Map<String, BikeSpecification> bikeList = BikeManager.getAllBikes();
		if (bikeList.containsKey(noPlate))
			errorList.add("Plate numbers must be unique");
		if (bikeList.containsKey(vin))
			errorList.add("VIN must be unique");
	}
}
