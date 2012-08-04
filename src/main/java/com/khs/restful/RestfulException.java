package com.khs.restful;

public class RestfulException extends Exception {

	public RestfulException(String message) {
		super(message);
	}
	
	public RestfulException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
