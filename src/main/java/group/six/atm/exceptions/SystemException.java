package group.six.atm.exceptions;

public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SystemException(String message) {
		super(message);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
