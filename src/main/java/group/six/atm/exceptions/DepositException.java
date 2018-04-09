package group.six.atm.exceptions;

/**
 * 存款异常
 * @author hayate
 *
 */
public class DepositException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DepositException(String message) {
		super(message);
	}
	
	public DepositException(String message, Throwable cause) {
		super(message, cause);
	}

}
