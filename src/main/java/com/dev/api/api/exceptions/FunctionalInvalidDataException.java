package com.dev.api.api.exceptions;

public class FunctionalInvalidDataException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String message;

	public FunctionalInvalidDataException(String message) {
		super();
		this.message = message;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
