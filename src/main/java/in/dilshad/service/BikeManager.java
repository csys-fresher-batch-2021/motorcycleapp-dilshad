package in.dilshad.service;

import java.util.List;

import in.dilshad.dao.BikeDAO;
import in.dilshad.exception.ServiceException;
import in.dilshad.exception.ValidationException;
import in.dilshad.model.BikeSpecification;
import in.dilshad.util.StringValidator;
import in.dilshad.validator.BikeValidator;

public class BikeManager {

	private BikeManager() {

	}

	/**
	 * Display the bikes available in show room
	 */
	public static List<BikeSpecification> displayBikes() {

		try {
			return BikeDAO.getAllBikes();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Adding the new bike to the Hash Map. Validation is done followed by addition.
	 * Exception is handled and exception message is forwarded.
	 * 
	 * @param newBike
	 */
	public static void addBike(BikeSpecification newBike) {
		try {
			BikeValidator.validateBikeSpecification(newBike);
			BikeDAO.addBike(newBike);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Validates the plate number. If invalid, immediate exception is thrown. If
	 * valid, hands over the plate number to DAO to search and returns the fetched
	 * bike details.
	 * 
	 * @param noPlate
	 * @return
	 */
	public static BikeSpecification searchByPlateNo(String noPlate) {
		BikeSpecification bikeSpecification = null;
		try {
			if (BikeValidator.isValidPlateNumber(noPlate))
				bikeSpecification = BikeDAO.getByPlateNo(noPlate);
			else {
				throw new ValidationException("Enter valid Plate number to fetch bike details");
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return bikeSpecification;
	}

	/**
	 * Validates the plate number. If invalid, immediate exception is thrown. If
	 * valid, hands over the plate no. to DAO to remove the corresponding row of the
	 * table from database.
	 * 
	 */
	public static void removeBike(String noPlate) {
		try {
			if (BikeValidator.isValidPlateNumber(noPlate)) {
				BikeDAO.removeBike(noPlate);
			} else {
				throw new ValidationException("Enter valid Plate number of bike to be removed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Validates plate no, odometer reading value and price and hand over to the DAO
	 * for updating the record with plate no as the key.
	 * 
	 * @param plateNo
	 * @param km
	 * @param price
	 */
	public static void updateBike(String plateNo, int km, int price) {
		try {
			if (BikeValidator.isValidPlateNumber(plateNo) && BikeValidator.isValidKm(km)
					&& BikeValidator.isValidBikePrice(price))
				BikeDAO.updateBike(plateNo, km, price);
			else
				throw new ValidationException("Enter valid details");
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Accepts Bike manufacturer and Bike model and hand over to DAO. Validation:
	 * Only presence of special character is found and exception is thrown User can
	 * fill either or both fields based their needs.
	 * 
	 * @param manufacturer
	 * @param model
	 * @return
	 */
	public static List<BikeSpecification> findBikeByModel(String manufacturer, String model) {
		try {
			if (!StringValidator.isValidString(manufacturer) && !StringValidator.isValidString(model))
				throw new ValidationException("Enter atleast one field to get bikes");
			else if (StringValidator.isSpecialCharPresent(manufacturer) || StringValidator.isSpecialCharPresent(model))
				throw new ValidationException("Special characters - not required for searching");
			else
				return BikeDAO.findBikeByModel(manufacturer, model);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public static List<BikeSpecification> shortlistByPrice(int min, int max) {
		try {
			if (!BikeValidator.isValidPriceLimit(min, max))
				throw new ValidationException("Invalid price limits");
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return BikeDAO.shortlistByPrice(min, max);
	}
}