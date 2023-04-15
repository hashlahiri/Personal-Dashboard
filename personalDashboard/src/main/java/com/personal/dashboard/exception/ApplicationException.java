package com.personal.dashboard.exception;


import com.personal.dashboard.domain.enums.ErrorResponseEnum;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private ErrorResponseEnum errorResponse;

	public ApplicationException(ErrorResponseEnum errorResponse) {
		super(errorResponse.getErrorText());
		this.errorResponse = errorResponse;
	}

	public ApplicationException(ErrorResponseEnum errorResponse, Throwable throwable) {
		super(throwable);
		this.errorResponse = errorResponse;
	}

	public ApplicationException(String errorMessage) {
		super(errorMessage);
	}

	public ErrorResponseEnum getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponseEnum errorResponse) {
		this.errorResponse = errorResponse;
	}

}
