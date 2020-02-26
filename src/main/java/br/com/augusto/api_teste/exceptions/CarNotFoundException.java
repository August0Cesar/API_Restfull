package br.com.augusto.api_teste.exceptions;

@SuppressWarnings("serial")
public class CarNotFoundException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CarNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
