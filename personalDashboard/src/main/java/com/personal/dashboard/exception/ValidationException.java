package com.personal.dashboard.exception;

import com.personal.dashboard.domain.enums.ErrorResponseEnum;

import java.util.List;

public class ValidationException extends ApplicationException {

	private static final long serialVersionUID = -6716946745272850153L;

	// To throw single error.
	private ValidationError validationError;

	// To throw multiple errors.
	private List<ValidationError> validationErrorList;

	public ValidationException(List<ValidationError> validationErrorList, ErrorResponseEnum errorResponse) {
		super(errorResponse);
		this.validationErrorList = validationErrorList;
	}

	public ValidationException(List<ValidationError> validationErrorList, ErrorResponseEnum errorResponse,
			Throwable throwable) {
		super(errorResponse, throwable);
		this.validationErrorList = validationErrorList;
	}

	public ValidationException(ValidationError validationError, ErrorResponseEnum errorResponse) {
		super(errorResponse);
		this.validationError = validationError;
	}

	public ValidationException(ValidationError validationError, ErrorResponseEnum errorResponse, Throwable throwable) {
		super(errorResponse, throwable);
		this.validationError = validationError;
	}

	public ValidationError getValidationError() {
		return validationError;
	}

	public List<ValidationError> getValidationErrorList() {
		return validationErrorList;
	}

	public void setValidationError(ValidationError validationError) {
		this.validationError = validationError;
	}

	public void setValidationErrorList(List<ValidationError> validationErrorList) {
		this.validationErrorList = validationErrorList;
	}
}