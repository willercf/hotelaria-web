package br.fpu.tcc.hotelaria.model.bo.exception;

public class AuthenticateException extends BoException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticateException() {
	}

	public AuthenticateException(String message) {
		super(message);
	}

	public AuthenticateException(String message, String keyMesage) {
		super(message, keyMesage);
	}

	public AuthenticateException(Throwable cause) {
		super(cause);
	}

	public AuthenticateException(String message, Throwable cause) {
		super(message, cause);
	}

}
