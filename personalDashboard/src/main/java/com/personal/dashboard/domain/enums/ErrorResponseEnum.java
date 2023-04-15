package com.personal.dashboard.domain.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorResponseEnum {

	GENERAL_ERROR(100, "An exception has occured while processing your request.", HttpStatus.INTERNAL_SERVER_ERROR),

	VALIDATION_ERROR(101, "There was one or more validation error(s)", HttpStatus.BAD_REQUEST),

	INVALID_URL(102, "Invalid url, request not found", HttpStatus.NOT_FOUND),

	ENTITY_NOT_FOUND(103, "The requested entity could not be found", HttpStatus.BAD_REQUEST),

	FILE_UPLOAD_ERROR(104, "An exception has occured while uploading file.", HttpStatus.BAD_REQUEST),

	ENTITY_ALREADY_EXISTS(105, "An entity already exists.", HttpStatus.CONFLICT),

	PAGINATION_LIMIT_ERROR(107, "Limit field is more than what is allowed.", HttpStatus.BAD_REQUEST),

	DUPLICATE_REFERENCE_NAME_ERROR(108, "Reference is already used by organization.", HttpStatus.BAD_REQUEST),

	USER_CONFLICT(109, "User already exists", HttpStatus.CONFLICT),

	ACCESS_DENIED(110, "Access Denied", HttpStatus.FORBIDDEN), CONFLICT(113, "conflict occured", HttpStatus.CONFLICT),

	DATA_MISSING(111, "Some Inputs are missing", HttpStatus.BAD_REQUEST),

	TOO_MANY_REQUESTS(112, "Too Many Requests", HttpStatus.TOO_MANY_REQUESTS),

	NOT_IMPLEMENTED(113, "NOT IMPLEMENTED", HttpStatus.NOT_IMPLEMENTED),

	UNPROCESSABLE_ENTITY(114, "UNPROCESSABLE ENTITY", HttpStatus.UNPROCESSABLE_ENTITY),

	UNPROCESSABLE_TRANSACTION(115, "Unable to Process Transaction", HttpStatus.UNPROCESSABLE_ENTITY),

	INVALID_CREDENTIALS(117, "Wrong Credentials", HttpStatus.BAD_REQUEST),

	SUBSCRIPTION_CONFLICT(119, "Subscription Conflict Occured", HttpStatus.CONFLICT),

	UNPROCESSABLE_SOCIAL_LOGIN(120, "Unable to Process Social Login", HttpStatus.UNPROCESSABLE_ENTITY),

	SERVICE_UNAVAILABLE(121, "Service Unavailable", HttpStatus.SERVICE_UNAVAILABLE),

	INVALID_FILE(122, "Invalid File", HttpStatus.BAD_REQUEST),

	INVALID_FILE_DATA(123, "Invalid File Data", HttpStatus.BAD_REQUEST),

	INSUFFICIENT_CREDIT_BALANCE(124, "Insufficient Balance", HttpStatus.FORBIDDEN),

	INVALID_CAPTCHA_RESPONSE(125, "Invalid Captcha Response", HttpStatus.BAD_REQUEST),
	
	USER_CONFLICT_UNVERIFIED_STATE(127, "User already exists and unverified!", HttpStatus.CONFLICT),
	
	AUTHENTICATION_FAILED(128, "Authorization Failed!", HttpStatus.UNAUTHORIZED);

	private int code;

	private String errorText;

	private HttpStatus httpStatus;

}
