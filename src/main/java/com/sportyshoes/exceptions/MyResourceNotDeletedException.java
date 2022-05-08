package com.sportyshoes.exceptions;

public class MyResourceNotDeletedException extends Exception {

	private static final long serialVersionUID = 4953037043754079167L;

	public MyResourceNotDeletedException(String errorMessage) {
		super(errorMessage);
	}

}
