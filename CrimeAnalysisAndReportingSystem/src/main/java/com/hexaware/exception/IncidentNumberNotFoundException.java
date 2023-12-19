package com.hexaware.exception;

/**
 * 
 */
public class IncidentNumberNotFoundException extends Exception {
	public IncidentNumberNotFoundException() {
		System.err.println("IncidentNumberNotFoundException");
	}

	@Override
	public String toString() {
		return "Incident Number Not Found in the Database!!!";
	}
	
}
