package in.dilshad.service;

import java.util.List;

import in.dilshad.dao.BikeDAO;
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
			e.printStackTrace();
			return null;
		}
		// final List<BikeSpecification> bikeList = new ArrayList<>();
//		try {
//			List<BikeSpecification> bikeList = BikeDAO.getAllBikes();
//			for (BikeSpecification bike : bikeList)
//				System.out.println(bike);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		// return BikeDAO.getAllBikes();
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

	public static BikeSpecification searchByPlateNo(String plateNo) {
		BikeSpecification bikeSpecification = null;
		try {
			BikeValidator.isValidPlateNumber(plateNo);
			bikeSpecification = BikeDAO.getByPlateNo(plateNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bikeSpecification;
	}
}
