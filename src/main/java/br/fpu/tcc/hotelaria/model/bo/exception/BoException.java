package br.fpu.tcc.hotelaria.model.bo.exception;

public class BoException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BoException() {
	}

	public BoException(String message) {
		super(message);
	}

	public BoException(Throwable cause) {
		super(cause);
	}

	public BoException(String message, Throwable cause) {
		super(message, cause);
	}

}
