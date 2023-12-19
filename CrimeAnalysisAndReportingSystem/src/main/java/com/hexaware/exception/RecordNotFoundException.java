package com.hexaware.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		System.err.println("RecordNotFoundException");
	}

	@Override
	public String toString() {
		return "Record Not Found in the Database!!!";
	}
	
}	
