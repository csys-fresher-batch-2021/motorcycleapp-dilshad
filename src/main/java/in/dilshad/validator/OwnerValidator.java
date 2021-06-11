package in.dilshad.validator;

import java.util.ArrayList;
import java.util.List;

import in.dilshad.dto.OwnerDTO;
import in.dilshad.exception.ValidationException;
import in.dilshad.util.StringValidator;

public class OwnerValidator {
	private OwnerValidator() {
		//Default constructor
	}
	/**
	 * Validates the owner details and throws exception consisting of list of
	 * incorrect fields.
	 * 
	 * @param owner
	 * @throws IllegalArgumentException
	 * @throws ValidationException
	 */
	public static void validateOwnerDetails(OwnerDTO owner) throws IllegalArgumentException, ValidationException {
		List<String> errorList = new ArrayList<>();

		if (!isValidName(owner.getOwnerName()))
			errorList.add("Enter Valid name");

		if (!isValidAddress(owner.getOwnerAddress()))
			errorList.add("Enter valid address");

		if (!isValidPhoneNo(owner.getOwnerPhoneNo()))
			errorList.add("Enter valid Phone number");
		if (!errorList.isEmpty()) {
			String errorMessage = String.join(",", errorList);
			throw new ValidationException(errorMessage);
		}

	}

	/**
	 * Validates the name of the owner. Length of the string must be in the range
	 * [2,20]
	 * 
	 * @param ownerName
	 * @return
	 */
	public static boolean isValidName(String ownerName) {
		return StringValidator.isValidString(ownerName, 20, 2);
	}

	/**
	 * Validates the address of the owner. Length of the string must be in the range
	 * [5,200]
	 * 
	 * @param ownerAddress
	 * @return
	 */
	public static boolean isValidAddress(String ownerAddress) {
		return StringValidator.isValidString(ownerAddress, 200, 5);
	}

	/**
	 * Validates the phone number. Should start with 9, 8, 7 or 6. Total 10 digits.
	 * 
	 * @param phoneNo
	 * @return
	 */
	public static boolean isValidPhoneNo(Long phoneNo) {
		boolean isValid = false;
		Long n = phoneNo / 1000000000;
		if (n >= 6 && n < 10)
			isValid = true;
		return isValid;
	}

}
