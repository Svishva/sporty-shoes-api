package com.sportyshoes.exceptions;

public class MyResourceNotCreatedException extends Exception {

	private static final long serialVersionUID = -7861827043078860058L;

	public MyResourceNotCreatedException(String errorMessage) {
		super(errorMessage);
	}

}
