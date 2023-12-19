package com.hexaware.controller;

import com.hexaware.dao.CasesDao;
import com.hexaware.entity.Cases;
import com.hexaware.entity.Incidents;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.IncidentNumberNotFoundException;
import com.hexaware.exception.InvalidDataException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The CaseController class manages the operations related to cases in a law enforcement system.
 * It includes methods to interact with case data, such as adding cases, updating case details, retrieving
 * all cases, and getting specific case information.
 */
public class CaseController {

    /**
     * List to store instances of Cases.
     */
    public static List<Cases> caseList = new ArrayList<>();

    /**
     * Input stream reader for reading input from the console.
     */
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);

    /**
     * Buffered reader for efficient reading of input.
     */
    private BufferedReader bufferReader = new BufferedReader(inputStreamReader);

    /**
     * Data access object for managing case data in the database.
     */
    private CasesDao caseDao = new CasesDao();

    /**
     * Instance of Cases for managing case information.
     */
    private Cases cases;

    /**
     * Populates the caseList by retrieving data from the database.
     */
    public void putCasesToArray() {
        caseDao.putCaseToArray();
    }

    /**
     * Adds a new case to the system. The method prompts the user for case details such as ID, related incident ID,
     * and case description. It ensures that the entered data is valid, the related incident exists, and the case
     * does not contain duplicates before adding it to the list and the database.
     */
	public void addCase() {
		StringBuffer str=new StringBuffer("");
		cases=new Cases();
		try {
			System.out.println("Enter Case Id:");
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||str.toString().contains("-"))
				throw new InvalidDataException();
			cases.setCaseId(Integer.parseInt(str.toString()));
			
			System.out.println("Enter Related Incident Id:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||str.toString().contains("-"))
				throw new InvalidDataException();
			
			boolean isIncidentAvailable=false;
			for(Incidents i:IncidentController.incidentList) {
				if(i.getIncidentId()==Integer.parseInt(str.toString())) {
					isIncidentAvailable=true;
					cases.setRelatedIncidents(i);
					break;
				}
			}
			if(!isIncidentAvailable)
				throw new IncidentNumberNotFoundException();
			
			System.out.println("Enter Case Description:");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			cases.setCaseDescription(str.toString());
			
			boolean containsObject = caseList.stream()
	                .anyMatch(obj -> obj.getCaseId()==cases.getCaseId());
			
			
			if(containsObject) {
				throw new DuplicateDataException();
			}
			
			caseList.add(cases);
			caseDao.addCase(cases);
			System.out.println("Case Added Succesfully!!");
			
			
		}catch(InvalidDataException e) {
			System.err.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IncidentNumberNotFoundException e) {
			System.err.println(e);
		} catch (DuplicateDataException e) {
			System.err.println(e);
		}
	}
	
	/**
     * Retrieves all cases from the database and displays their details.
     */
    public void getAllCases() {
        caseList = caseDao.getAllCases();
        for (Cases cases : caseList) {
            System.out.println(cases);
        }
    }

    /**
     * Updates the details of a specific case. The method prompts the user for the case ID to be updated and
     * provides options to update the related incident and case description. It ensures that the entered data is valid
     * and that the related incident exists before updating the case details in the database.
     */
    public void updateCase(int id) {
		// TODO Auto-generated method stub
		StringBuffer str=new StringBuffer("");
		cases=new Cases();
		char ch;
		Scanner sc=new Scanner(System.in);
		try {
			for(Cases cases:caseList){
				if(cases.getCaseId()==id) {
					System.out.println("Update Incident? (y/n)");
					ch=sc.next().charAt(0);
					if(ch=='y') {
						System.out.println("Enter Related Incident Id:");
						str=str.append(bufferReader.readLine());
						if(str.toString().equals("")||str.toString().contains("-"))
							throw new InvalidDataException();
						
						boolean isIncidentAvailable=false;
						for(Incidents i:IncidentController.incidentList) {
							if(i.getIncidentId()==Integer.parseInt(str.toString())) {
								isIncidentAvailable=true;
								cases.setRelatedIncidents(i);
								break;
							}
						}
						if(!isIncidentAvailable)
							throw new IncidentNumberNotFoundException();
						
					}
					
					System.out.println("Update Case Description? (y/n)");
					ch=sc.next().charAt(0);
					if(ch=='y') {
						System.out.println("Enter Case Description:");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						cases.setCaseDescription(str.toString());
					}
					caseDao.updateCaseDetails(cases);
				}
			}
		}catch(IncidentNumberNotFoundException e) {
			System.err.println(e);
		}catch(InvalidDataException e) {
			System.err.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * Retrieves and displays details of a specific case based on the provided case ID.
     *
     * @param id The ID of the case to be retrieved and displayed.
     */
	public void getCase(int id) {
		for(Cases c:caseList) {
			if(c.getCaseId()==id) {
				System.out.println(c);
				return;
			}
		}
	}
}

