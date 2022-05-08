package com.sportyshoes.exceptions;

public class MyResourceNotUpdatedException extends Exception {

	private static final long serialVersionUID = -3634085381970753058L;

	public MyResourceNotUpdatedException(String errorMessage) {
		super(errorMessage);
	}

}
