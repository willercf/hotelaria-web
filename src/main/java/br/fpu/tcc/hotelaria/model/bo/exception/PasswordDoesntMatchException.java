package br.fpu.tcc.hotelaria.model.bo.exception;

public class PasswordDoesntMatchException extends BoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PasswordDoesntMatchException() {
	}

	public PasswordDoesntMatchException(String message) {
		super(message);
	}

	public PasswordDoesntMatchException(Throwable cause) {
		super(cause);
	}

	public PasswordDoesntMatchException(String message, Throwable cause) {
		super(message, cause);
	}

}
