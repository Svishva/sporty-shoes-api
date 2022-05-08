package com.sportyshoes.exceptions;

public class MyResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 2428741162222844785L;

	public MyResourceNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
