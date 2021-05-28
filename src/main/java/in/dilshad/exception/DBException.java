package in.dilshad.exception;

public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * User Defined Exception - for database
	 * 
	 * @param message
	 */
	public DBException(String message) {
		super(message);
	}

}