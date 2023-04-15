package com.personal.dashboard.exception;

import lombok.Data;

@Data
public class ValidationError {

	private String errorMessage;

	private String fieldName;

	public ValidationError(String fieldName, String errorMessage) {
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getFieldName() {
		return fieldName;
	}

	@Override
	public String toString() {
		return " { fieldName : " + this.fieldName + ", errorMessage : " + this.errorMessage + " }";
	}
}