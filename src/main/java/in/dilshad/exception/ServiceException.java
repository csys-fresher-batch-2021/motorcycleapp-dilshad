package in.dilshad.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * User Defined Exception - for database
	 * 
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

}