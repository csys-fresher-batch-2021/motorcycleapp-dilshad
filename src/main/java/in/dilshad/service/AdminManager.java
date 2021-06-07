package in.dilshad.service;

import in.dilshad.dao.AdminDAO;
import in.dilshad.exception.ServiceException;
import in.dilshad.model.AdminDetails;
import in.dilshad.validator.AdminValidator;

public class AdminManager {
	private AdminManager() {

	}

	public static void registerAdmin(AdminDetails admin) {
		try {
			AdminValidator.validateRegister(admin);
		} catch (Exception e) {
			throw new ServiceException("Enter fields in proper format");
		}
		try {
			AdminDAO.addDAO(admin);
		} catch (Exception e) {
			throw new ServiceException("Admin ID already exist");
		}
	}

	public static String adminLogin(AdminDetails adminDetails) {

		try {
			return AdminDAO.loginVerificationDAO(adminDetails);
		} catch (Exception e) {
			throw new ServiceException("Error");
		}

	}
}