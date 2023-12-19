package com.hexaware.controller;

import com.hexaware.dao.SuspectsDao;
import com.hexaware.entity.Suspects;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * The {@code SuspectController} class serves as a controller for managing a list of suspects
 * and interacting with a data access object ({@code SuspectsDao}) to populate and 
 * display suspect information.
 * It provides methods to populate the list and display details about the suspects.
 */
public class SuspectController {

  /**
     * The list containing instances of {@code Suspects}.
     */
  public static List<Suspects> suspectsList = new ArrayList<>();

  /**
     * The data access object used to retrieve suspect information from the database.
     */
  private SuspectsDao suspectDataAccessObject = new SuspectsDao();

  /**
   * Input stream reader for reading input from the console.
   */
  private InputStreamReader inputStreamReader = new InputStreamReader(System.in);

  /**
   * Buffered reader for efficient reading of input.
   */
  private BufferedReader bufferReader = new BufferedReader(inputStreamReader);
  
  /**
   * Object of {@code Suspects} class.
   */
  private Suspects suspect;
  
  /**
     * Populates the {@code suspectsList} by fetching suspect information from the database
     * using the associated data access object.
     */
  public void putSuspectsToArray() {
    suspectsList.clear(); // Clear the list before adding new suspects
    suspectDataAccessObject.putSuspectsToArray();
    suspectsList.addAll(SuspectController.suspectsList);
  }

  /**
     * Displays information about the suspects in the {@code suspectsList}.
     */
  public void showSuspects() {
    for (Suspects s : suspectsList) {
      System.out.println(s);
    }
  }

  /**
   * Takes user input and validates it then adds
   *  the suspects in the {@code suspectsList} and
   *  sends the suspect object to the {@link SuspectsDao} file.
   */
  public void addSuspect() {
    StringBuffer str = new StringBuffer("");
    suspect=new Suspects();
    try {
    	System.out.println("Enter Suspect Id:");
    	str=str.append(bufferReader.readLine());
    	if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
    		throw new InvalidDataException();
    	
    	suspect.setSuspectId(Integer.parseInt(str.toString()));
    	
    	System.out.println("Enter Suspects First Name:");
    	str.setLength(0);
    	str=str.append(bufferReader.readLine());
    	if(str.toString().equals(""))
    		throw new InvalidDataException();
    	suspect.setFirstName(str.toString());
    	
    	System.out.println("Enter Suspects Last Name:");
    	str.setLength(0);
    	str=str.append(bufferReader.readLine());
    	if(str.toString().equals(""))
    		throw new InvalidDataException();
    	suspect.setLastName(str.toString());	
    	
    	System.out.println("Enter Suspects DOB(yyyy-mm-dd):");
		str.setLength(0);
    	str=str.append(bufferReader.readLine());
    	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate dob=LocalDate.parse(str.toString(),formatter);
    	if(dob.isAfter(LocalDate.now())||dob==null)
    		throw new InvalidDataException();
    	suspect.setDob(LocalDate.parse(str.toString()));
    	
    	System.out.println("Enter Suspects Gender:");
    	str.setLength(0);
    	str=str.append(bufferReader.readLine());
    	if(str.toString().equals(""))
    		throw new InvalidDataException();
    	suspect.setGender(str.toString());
    	
    	System.out.println("Enter Suspects ContactInfo:");
    	str.setLength(0);
    	str=str.append(bufferReader.readLine());
    	if(str.toString().equals(""))
    		throw new InvalidDataException();
    	suspect.setContactInfo(str.toString());
    	
    	boolean containsObject = suspectsList.stream()
                .anyMatch(obj -> obj.getSuspectId()==suspect.getSuspectId());
		
		
		if(containsObject) {
			throw new DuplicateDataException();
		}
    	
    	suspectsList.add(suspect);
    	suspectDataAccessObject.addSuspects(suspect);
    	
    }catch(IOException e) {
    	e.printStackTrace();
    } catch (InvalidDataException e) {
		System.err.println(e);
	} catch (DuplicateDataException e) {
		System.err.println(e);
	}
  }
}
