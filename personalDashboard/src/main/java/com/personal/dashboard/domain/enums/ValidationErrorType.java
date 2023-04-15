package com.personal.dashboard.domain.enums;

public enum ValidationErrorType {
	EMAIL_EXISTS("EMAIL_EXISTS"),

	INVALID_VALUE("INVALID_VALUE"),

	MULTIPLE_CONTENT_OF_SAME_LANG("MULTIPLE_CONTENT_OF_SAME_LANG"),

	REQUIRED_FIELD_MISSING("REQUIRED_FIELD_MISSING"),

	SOCIAL_LOGIN("SOCIAL_LOGIN"),

	TRANSACTION("TRANSACTION_FAILED"),

	UNPROCESSABLE("UNPROCESSABLE"),

	INSUFFICIENT_BALANCE("INSUFFICIENT_BALANCE"),

	FILE_UPLOAD_ERROR("FILE_UPLOAD_ERROR"),

	USERNAME_TAKEN("USERNAME_TAKEN"),

	VALUE_ALREADY_IN_USE("VALUE_ALREADY_IN_USE"),
	
	BAD_CREDENTIALS("BAD_CREDENTIALS");

	private String errorType;

	ValidationErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
}