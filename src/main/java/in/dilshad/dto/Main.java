package in.dilshad.dto;

import java.util.List;

import in.dilshad.dao.OwnerDAO;

public class Main {

	public static void main(String[] args) {
		List<UnverifiedBikeDTO> bikes= OwnerDAO.getUnverifiedBikes();
		System.out.println(bikes);
	}

}
