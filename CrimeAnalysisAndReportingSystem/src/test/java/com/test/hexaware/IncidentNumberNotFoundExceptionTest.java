package com.test.hexaware;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hexaware.exception.IncidentNumberNotFoundException;

public class IncidentNumberNotFoundExceptionTest {
	
	private static IncidentNumberNotFoundException exception;
	
	@BeforeClass
	public static void setUp() {
		exception=new IncidentNumberNotFoundException();
	}
	
	@Test(expected=IncidentNumberNotFoundException.class)
	public void testPrint(){
		System.out.println(exception);
	}
	
	 @Test
	   public void testSalutationMessage() {
	     String message="Incident Number Not Found in the Database!!!"; 
		 assertEquals(message,exception.toString());
	   }
	 
	 @AfterClass
	 public static void tearDown() {
		 exception=null;
	 }
}
