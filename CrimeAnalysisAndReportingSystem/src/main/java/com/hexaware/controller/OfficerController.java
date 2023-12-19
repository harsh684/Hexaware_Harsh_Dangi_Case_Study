package com.hexaware.controller;

import com.hexaware.dao.OfficersDao;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.entity.Officers;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;
import com.hexaware.exception.RecordNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code OfficerController} class serves as a controller for managing a list of officers,
 * allowing interactions with a data access object ({@code OfficersDao}) 
 * to populate, add, and display officer information.
 * It provides methods to populate the list, add new officers, display information about officers,
 * and retrieve an officer by their ID. The class also handles 
 * user input, data validation, and exception handling.
 */
public class OfficerController {
    /**
     * The list containing instances of {@code Officers}.
     */
    public static List<Officers> officerList = new ArrayList<>();

    /**
     * Input stream reader for reading input from the console.
     */
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);

    /**
     * Buffered reader for efficient reading of input.
     */
    private BufferedReader bufferReader = new BufferedReader(inputStreamReader);

    /**
     * The officer object used for adding new officer details.
     */
    private Officers officer;

    /**
     * The data access object used to retrieve and store officer information in the database.
     */
    private OfficersDao officerDataAccessObject = new OfficersDao();

 /**
     * Populates the {@code officerList} by fetching officer information from the database
     * using the associated data access object.
     */
	public void putOfficersToArray() {
		officerDataAccessObject.putOfficersToArray();
	}
	
 /**
     * Adds a new officer to the {@code officerList} and stores the information in the database.
     * Prompts the user to enter officer details such as ID, first name, 
     * last name, badge number, rank,
     * contact information, and agency ID. Validates the input data to ensure correctness.
     */
	public void addOfficer() {
		StringBuffer str=new StringBuffer("");
		officer=new Officers();
		
		try {
			System.out.println("Enter Officer Id:");
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0) 
				throw new InvalidDataException();
			officer.setOfficerId(Integer.parseInt(str.toString()));
			
			System.out.println("Enter Officer First name:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setFirstName(str.toString());
			
			System.out.println("Enter Officer Last name:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setLastName(str.toString());
			
			System.out.println("Enter Officer Badge No:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setBadgeNo(str.toString());
			
			System.out.println("Enter Officer's Rank:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setRank(str.toString());
			
			System.out.println("Enter Officer's contact info:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			officer.setContactInfo(str.toString());
			
			System.out.println("Enter Officer's Agency Id:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0) 
				throw new InvalidDataException();
			
			for(LawEnforcementAgencies l:LawEnforcementAgencyController.agencyList) {
				if(l.getAgencyId()==Integer.parseInt(str.toString())) {
					officer.setAgency(l);
					break;
				}
			}
			
			boolean containsObject = officerList.stream()
	                .anyMatch(obj -> obj.getOfficerId()==officer.getOfficerId());
			
			
			if(containsObject) {
				throw new DuplicateDataException();
			}
			
			officerList.add(officer);
			officerDataAccessObject.addOfficer(officer);
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} catch (DuplicateDataException e) {
			System.err.println(e);
		}
	}
	
 /**
     * Displays information about the officers in the {@code officerList}.
     */
	public void displayOfficers() {
		for(Officers officer:officerList) {
			System.out.println(officer);
		}
	}
	
 /**
     * Retrieves and displays an officer by their ID.
     *
     * @param id The ID of the officer to retrieve.
     * @throws RecordNotFoundException If the officer with the specified ID is not found.
     */
	public void getOfficerById(int id) throws RecordNotFoundException {
		boolean isAvailable=false;
		for(Officers o:officerList) {
			if(o.getOfficerId()==id) {
				System.out.println(o);
				return;
			}
		}
		if(isAvailable==false)
			throw new RecordNotFoundException();
	}
}
