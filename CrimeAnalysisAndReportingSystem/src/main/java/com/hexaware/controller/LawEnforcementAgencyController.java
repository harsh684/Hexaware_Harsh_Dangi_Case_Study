package com.hexaware.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.AgencyDao;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;

/**
 * The LawEnforcementAgencyController class manages the operations related to law enforcement agencies.
 * It includes methods to interact with law enforcement agency data, such as adding agencies, displaying
 * agency details, and populating the agency list.
 */
public class LawEnforcementAgencyController {

    /**
     * List to store instances of LawEnforcementAgencies.
     */
    public static List<LawEnforcementAgencies> agencyList = new ArrayList<>();

    /**
     * Data access object for managing agency data in the database.
     */
    private AgencyDao agencyDao = new AgencyDao();

    /**
     * Input stream reader for reading input from the console.
     */
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);

    /**
     * Buffered reader for efficient reading of input.
     */
    private BufferedReader bufferReader = new BufferedReader(inputStreamReader);

    /**
     * Instance of LawEnforcementAgencies for managing agency information.
     */
    private LawEnforcementAgencies agency;

    /**
     * Populates the agencyList by retrieving data from the database.
     */
	public void putAgenciesToArray() {
		agencyDao.putSuspectsToArray();
	}

	/**
     * Adds a new law enforcement agency to the system. The method prompts the user for agency details
     * such as ID, name, jurisdiction, and contact information. It ensures that the entered data is valid
     * and does not contain duplicates before adding the agency to the list and the database.
     */
	public void addAgency() {
		StringBuffer str=new StringBuffer("");
		agency=new LawEnforcementAgencies();
		try {
			System.out.println("Enter Agency Id:");
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			agency.setAgencyId(Integer.parseInt(str.toString()));

			System.out.println("Enter Agency Name:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			agency.setAgencyName(str.toString());
			
			System.out.println("Enter Agency Jurisdiction:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			agency.setJurisdiction(str.toString());
			
			System.out.println("Enter Agencies contact Info:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			agency.setContactInfo(str.toString());
			
			boolean containsObject = agencyList.stream()
	                .anyMatch(obj -> obj.getAgencyId()==agency.getAgencyId());
			
			
			if(containsObject) {
				throw new DuplicateDataException();
			}
			
			agencyList.add(agency);
			agencyDao.addAgency(agency);
			
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
     * Displays details of all law enforcement agencies in the system.
     */
	public void showAllAgencies() {
		// TODO Auto-generated method stub
		for(LawEnforcementAgencies l:agencyList) {
			System.out.println(l);
		}
	}
}
