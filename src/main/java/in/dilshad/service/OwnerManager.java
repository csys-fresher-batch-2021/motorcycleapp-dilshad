package in.dilshad.service;

import java.util.List;

import in.dilshad.dao.OwnerDAO;
import in.dilshad.dto.OwnerDTO;
import in.dilshad.dto.UnverifiedBikeDTO;
import in.dilshad.exception.ServiceException;
import in.dilshad.validator.OwnerValidator;

public class OwnerManager {
	private OwnerManager() {
		
	}

	/**
	 * Accepts owner details and passes to DAO layer after validation is successful.
	 * 
	 * @param ownerDetails
	 */
	public static void addOwnerDetails(OwnerDTO ownerDetails) {
		try {
			OwnerValidator.validateOwnerDetails(ownerDetails);

			OwnerDAO.addOwner(ownerDetails);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Gets the List of NOT VERIFIED bike list along with corresponding owner
	 * details
	 * 
	 * @return
	 */
	public static List<UnverifiedBikeDTO> getUnverifiedBikeList() {
		try {
			return OwnerDAO.getUnverifiedBikes();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Removes the owner details from the database when corresponding plate number
	 * is passed.
	 * 
	 * @param plateNo
	 */
	public static void removeOwnerDetails(String plateNo) {
		try {
			OwnerDAO.removeOwner(plateNo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * When bike plate number is passed as an argument, it returns the corresponding
	 * details of the owner.
	 * 
	 * @param plateNo
	 * @return
	 */
	public static OwnerDTO getOwnerDetails(String plateNo) {
		try {
			return OwnerDAO.getOwnerDetails(plateNo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
