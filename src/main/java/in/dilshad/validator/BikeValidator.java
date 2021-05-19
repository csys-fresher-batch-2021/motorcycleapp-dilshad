package in.dilshad.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import in.dilshad.model.BikeSpecification;

public class BikeValidator {
	private BikeValidator() {
		// to avoid object creation
	}

	/**
	 * This method checks the Bike Specification fields. Throws exception when any
	 * one of the Bike Specification goes wrong.
	 * 
	 * @param newBike
	 * @throws IllegalArgumentException
	 */
	public static void validateBikeSpecification(BikeSpecification newBike) throws IllegalArgumentException {
		List<String> errorList = new ArrayList<>();
		if (!isValidBikeManufacturer(newBike.bikeManufacturer))
			//errorList = String.join(" /===/ ", errorList, "Enter Valid Bike Manufacturer");
			errorList.add("Enter Valid Bike Manufacturer");

		if (!isValidBikeModel(newBike.bikeModel))
			//errorList = String.join(" /===/ ", errorList, "Enter Valid Bike Model");
			errorList.add("Enter Valid Bike Model");

		if (!BikeValidator.isValidBikeColor(newBike.bikeColor))
			//errorList = String.join(" /===/ ", errorList, "Enter Valid Bike Color");
			errorList.add("Enter Valid Bike Color");

		if (!BikeValidator.isValidKm(newBike.km))
			//errorList = String.join(" /===/ ", errorList, "Enter Valid Oddometer Reading");
			errorList.add("Enter Valid Oddometer Reading");

		if (!BikeValidator.isValidManufactureYear(newBike.manufactureYear))
//			errorList = String.join(" /===/ ", errorList, "Enter Valid Bike Manufacture Year");
			errorList.add("Enter Valid Bike Manufacture Year");

		if (!isValidVin(newBike.engineDetails.get("vin")))
//			errorList = String.join(" /===/ ", errorList, "Enter Valid VIN");
			errorList.add("Enter Valid VIN");

		if (!isValidPlateNumber(newBike.engineDetails.get("noPlate")))
//			errorList = String.join(" /===/ ", errorList, "Enter Valid Plate number");
			errorList.add("Enter Valid Plate number");

		if (!isValidBikePrice(newBike.bikePrice))
//			errorList = String.join(" /===/ ", errorList, "Enter Valid Bike Price");
			errorList.add("Enter Valid Bike Price");
			
		//errorList.stream().collect.joining(","));
		// String str = geeklist.stream().collect(Collectors.joining(","));
		// String str = String.join(",", geeklist);
		//Convert List to comma separated string
		
		
		if (!errorList.isEmpty()) {
			String errorMessage = String.join("\n", errorList);
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
		return StringValidator.isAlpha(BikeModel);
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
		if (StringValidator.isValidString(noPlate))
			isValid = Pattern.matches("[A-Z]{2}[0-9]{2}[A-Z]{1}[0-9]{4}", noPlate);
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
		if (km > 0 && km < 300000)
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
		if (StringValidator.isValidString(vin)) {
			Pattern pattern = Pattern.compile("[A-Z0-9]{17}");
			Matcher matcher = pattern.matcher(vin);
			isValid = matcher.find();
		}
		return isValid;
	}
}
