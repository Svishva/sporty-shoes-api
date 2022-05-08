package com.sportyshoes.exceptions;

public class DatabaseOperationException extends Exception {


	private static final long serialVersionUID = -324834536658139381L;

	public DatabaseOperationException(String errorMessage) {
		super(errorMessage);
	}

	public DatabaseOperationException(String errorMessage, Exception e) {
		super(errorMessage, e);
	}

}
