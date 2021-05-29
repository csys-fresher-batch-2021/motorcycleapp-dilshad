package in.dilshad.service;

import java.util.List;

import in.dilshad.dao.BikeDAO;
import in.dilshad.exception.ValidationException;
import in.dilshad.model.BikeSpecification;
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
			throw new RuntimeException(e.getMessage());
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
			throw new IllegalArgumentException(e.getMessage());
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
			throw new RuntimeException(e.getMessage());
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
			throw new RuntimeException(e.getMessage());
		}

	}
}
