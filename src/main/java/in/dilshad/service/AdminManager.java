package in.dilshad.service;

import in.dilshad.dao.AdminDAO;
import in.dilshad.exception.ServiceException;
import in.dilshad.model.AdminDetails;
import in.dilshad.validator.AdminValidator;

public class AdminManager {
	private AdminManager() {

	}

	/**
	 * Admin registration form. Accepts admin details, validates and passes to DAO
	 * 
	 * @param admin
	 */
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

	/**
	 * Admin Login form. Accept admin details and returns admin name from the
	 * database if valid credentials is passed.
	 * 
	 * @param adminDetails
	 * @return
	 */
	public static String adminLogin(AdminDetails adminDetails) {

		try {
			return AdminDAO.loginVerificationDAO(adminDetails);
		} catch (Exception e) {
			throw new ServiceException("Error");
		}

	}
}