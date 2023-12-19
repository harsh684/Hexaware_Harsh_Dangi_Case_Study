package com.hexaware.exception;

public class DuplicateDataException extends Exception {

	public DuplicateDataException() {
		System.out.println("Duplicate Data Exception");
	}

	@Override
	public String toString() {
		return "Duplicate Data Entered!!";
	}
	
}
