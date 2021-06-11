package in.dilshad.service;

import java.util.List;

import in.dilshad.dao.OwnerDAO;
import in.dilshad.dto.OwnerDTO;
import in.dilshad.dto.UnverifiedBikeDTO;

public class OwnerManager {

	public static void addOwnerDetails(OwnerDTO ownerDTO) {
		
		OwnerDAO.addOwner(ownerDTO);
	}
	
	public static List<UnverifiedBikeDTO> getUnverifiedBikeList() {
		return OwnerDAO.getUnverifiedBikes();
	}

	public static void removeOwnerDetails(String plateNo) {
		OwnerDAO.removeOwner(plateNo);
	}
	
	public static OwnerDTO getOwnerDetails(String plateNo) {
		
		return OwnerDAO.getOwnerDetails(plateNo);
	}
}
