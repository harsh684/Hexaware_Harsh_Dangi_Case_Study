package com.hexaware.controller;

import com.hexaware.dao.ReportsDao;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Officers;
import com.hexaware.entity.Reports;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;
import com.hexaware.exception.RecordNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ReportController} class serves as a controller for managing a list of reports,
 * allowing interactions with a data access object ({@code ReportsDao}) 
 * to populate, add, and display report information.
 * It provides methods to populate the list, add new reports, display information about reports,
 * and retrieve a report by its ID. The class also handles user input, data validation, 
 * and exception handling.
 */
public class ReportController {

	/**
     * The list containing instances of {@code Reports}.
     */
    public static List<Reports> reportsList = new ArrayList<>();

    /**
     * Input stream reader for reading input from the console.
     */
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);

    /**
     * Buffered reader for efficient reading of input.
     */
    private BufferedReader bufferReader = new BufferedReader(inputStreamReader);

    /**
     * The report object used for adding new report details.
     */
    private Reports report;

    /**
     * The data access object used to retrieve and store report information in the database.
     */
    private ReportsDao reportsDataAccessObject = new ReportsDao();

 /**
     * Populates the {@code reportsList} by fetching report information from the database
     * using the associated data access object.
     */
	public void putReportsToArray() {
		reportsDataAccessObject.putReportsToArray();
	}
	
 /**
     * Adds a new report to the {@code reportsList} and stores the information in the database.
     * Prompts the user to enter report details such as ID, 
     * incident ID, reporting officer ID, date, details, and status.
     * Validates the input data to ensure correctness.
     */
	public void addReport() {
		StringBuffer str=new StringBuffer("");
		report=new Reports();
		boolean isAvailable=false;
		try {
			System.out.print("Enter Report Id: ");
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			report.setReportId(Integer.parseInt(str.toString()));
			
			System.out.print("Enter Incident id: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			
			for(Incidents i:IncidentController.incidentList) {
				if(i.getIncidentId()==Integer.parseInt(str.toString())) {
					report.setIncident(i);
					isAvailable=true;
					break;
				}
			}
			if(isAvailable==false)
				throw new RecordNotFoundException();
			isAvailable=false;
			
			System.out.print("Enter Reporting Officer Id: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			
			for(Officers s:OfficerController.officerList) {
				if(s.getOfficerId()==Integer.parseInt(str.toString())) {
					report.setReportingOfficer(s);
					isAvailable=true;
					break;
				}
			}
			if(isAvailable==false)throw new RecordNotFoundException();
			isAvailable=false;
			
			System.out.print("Enter Report Date: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			
			report.setReportDate(LocalDate.parse(str.toString()));
			
			System.out.print("Enter Report Details: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			report.setReportDetails(str.toString());

			System.out.println("Enter Report Status: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")) 
				throw new InvalidDataException();
			report.setReportStatus(str.toString());
			
		    boolean containsObject = reportsList.stream()
	                .anyMatch(obj -> obj.getReportId()==report.getReportId());
			
			
			if(containsObject) {
				throw new DuplicateDataException();
			}
			reportsList.add(report);
			if(reportsDataAccessObject.addReport(report)) {
				System.out.println("Data inserted Successfully!!");
			}else {
				System.err.println("Data could not be inserted!!");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			System.err.println(e);
		}catch(DuplicateDataException e) {
			System.err.println(e);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
 /**
     * Displays information about the reports in the {@code reportsList}.
     */
	public void displayReports() {
		for(Reports r:reportsList) {
			System.out.println(r);
		}
	}
	
 /**
     * Retrieves and displays a report by its ID.
     *
     * @param id The ID of the report to retrieve.
     * @throws RecordNotFoundException If the report with the specified ID is not found.
     */
	public void getReportById(int id) throws RecordNotFoundException {
		boolean isAvailable=false;
		for(Reports r:reportsList) {
			if(r.getReportId()==id) {
				System.out.println(r);
				return;
			}
		}
		if(isAvailable==false)
			throw new RecordNotFoundException();
	}
	
}
