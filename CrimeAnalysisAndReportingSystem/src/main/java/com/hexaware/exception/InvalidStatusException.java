package com.hexaware.exception;

public class InvalidStatusException extends Exception {
	public InvalidStatusException() {
		System.err.println("InvalidStatusException");
	}

	@Override
	public String toString() {
		return "Invalid Status or Id Entered";
	}
	
}
