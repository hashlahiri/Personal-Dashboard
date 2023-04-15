package com.personal.dashboard.exception;


public class OtpMaxAttemptsException extends OtpException{
	
	
	private static final long serialVersionUID = 1291480482133211320L;

	public OtpMaxAttemptsException(String message) {
		super(message);
	}

}

