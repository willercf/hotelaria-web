package br.fpu.tcc.hotelaria.model.bo.exception;

public class BoException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String keyMessage;

	public BoException() {
	}

	public BoException(String message) {
		super(message);
	}

	public BoException(String message, String keyMesage) {
		super(message);
		this.keyMessage = keyMesage;
	}

	public BoException(Throwable cause) {
		super(cause);
	}

	public BoException(Throwable cause, String keyMesage) {
		super(cause);
		this.keyMessage = keyMesage;
	}

	public BoException(String message, Throwable cause) {
		super(message, cause);
	}

	public boolean hasKeyMessage() {
		return keyMessage != null;
	}

	public String getKeyMessage() {
		return keyMessage;
	}

}
