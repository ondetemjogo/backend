package com.ondetemjogo.newevent.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String error;

	public BusinessException(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
