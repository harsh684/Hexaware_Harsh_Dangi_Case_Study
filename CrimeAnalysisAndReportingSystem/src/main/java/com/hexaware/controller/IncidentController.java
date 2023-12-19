package com.hexaware.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.IncidentDao;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.entity.Suspects;
import com.hexaware.entity.Victims;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;
import com.hexaware.exception.InvalidStatusException;
import com.hexaware.exception.RecordNotFoundException;

/**
 * Controller class for managing incidents, including adding, updating, and searching incidents.
 */
public class IncidentController {

    /**
     * Represents an incident object.
     */
    private Incidents incident;

    /**
     * Represents a victim object.
     */
    private Victims victim;

    /**
     * Data access object for incidents.
     */
    private IncidentDao incidentDao = new IncidentDao();

    /**
     * Input stream reader for reading input from the console.
     */
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);

    /**
     * Buffered reader for efficient reading of input.
     */
    private BufferedReader bufferReader = new BufferedReader(inputStreamReader);

    /**
     * List to store incidents.
     */
    public static List<Incidents> incidentList = new ArrayList<Incidents>();

    /**
     * Puts incidents into an array by calling the data access object.
     */
	public void putIncidentsToArray() {
		incidentDao.putIncidentsToArray();
	}
	
	/**
     * Adds incidents by taking input from the user.
     */
	public void addIncidents() {
		StringBuffer str=new StringBuffer("");
		try {
			incident=new Incidents();
			System.out.print("Enter Incident Id: ");
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			incident.setIncidentId(Integer.parseInt(str.toString()));
			
			System.out.print("Enter Incident Type: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			incident.setIncidentType(str.toString());
			
			System.out.print("Enter Date of Incident: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			incident.setIncidentDate(LocalDate.parse(str.toString()));
			
			System.out.print("Enter Incident location: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			incident.setLocation(str.toString());
			
			System.out.print("Enter Incident Description: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			incident.setDescription(str.toString());
			
			System.out.println("Enter Incident status: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			incident.setStatus(Status.valueOf(str.toString().toUpperCase()).toString());
			
			System.out.println("Enter Victim Id: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			
			
			for(Victims v:VictimController.victimList) {
				if(v.getVictimId()==Integer.parseInt(str.toString())) {
					incident.setVictim(v);
					break;
				}
			}
			
			System.out.println("Enter Suspect Id: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			
			for(Suspects s:SuspectController.suspectsList) {
				if(s.getSuspectId()==Integer.parseInt(str.toString())) {
					incident.setSuspect(s);
					break;
				}
			}
			
			System.out.println("Enter Agency Id: ");
			str.setLength(0);
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			
			for(LawEnforcementAgencies la:LawEnforcementAgencyController.agencyList) {
				if(la.getAgencyId()==Integer.parseInt(str.toString())) {
					incident.setAgency(la);
					break;
				}
			}

			boolean containsObject = incidentList.stream()
	                .anyMatch(obj -> obj.getIncidentId()==incident.getIncidentId());
			
		    if(containsObject) {
				throw new DuplicateDataException();
			}
		    
			incidentList.add(incident);
			if(incidentDao.insertIncident(incident.getIncidentId(), incident.getIncidentType(), 
					incident.getIncidentDate(), incident.getLocation(), incident.getDescription(), 
					incident.getStatus(), incident.getVictim().getVictimId(), 
					incident.getSuspect().getSuspectId(), incident.getAgency().getAgencyId())) {
				System.out.println("Data inserted Successfully!!");
			}else {
				System.out.println("Data could not be inserted!!");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			System.err.println(e);
		}catch(DuplicateDataException e) {
			System.out.println(e);
		}catch(IllegalArgumentException e) {
			System.err.println("Invalid Status Type!!");
		}
		
	}
	
	/**
     * Gets incidents within a specified date range and displays them.
     *
     * @param s Start date of the range.
     * @param e End date of the range.
     */
	public void getIncidentsDateRange(LocalDate s, LocalDate e) {
		List<Incidents> res=incidentDao.getIncidentsInDateRange(s, e);
		for(Incidents i:res) {
			System.out.println(i);
			System.out.println();
		}
	}
	
	/**
     * Updates incident details based on the provided incident ID.
     *
     * @param id The ID of the incident to be updated.
     */
	public void updateIncident(int id) {
		char ch;
		StringBuffer str=new StringBuffer("");
		Scanner sc=new Scanner(System.in);
		try {
			for(Incidents t1:incidentList) {
				if(t1.getIncidentId()==id) {
					System.out.println("Update Incident Type? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter Type: ");
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						
						t1.setIncidentType(str.toString());
					}
					System.out.println("Update Incident Date? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter Date(yyyy-mm-dd): ");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						
						t1.setIncidentDate(LocalDate.parse(str.toString()));
					}
					System.out.println("Update Location? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter location: ");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						
						t1.setLocation(str.toString());
					}
					System.out.println("Update Description? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter description: ");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						
						t1.setDescription(str.toString());
					}
					System.out.println("Update Status? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter status: ");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						
						t1.setStatus(str.toString());
					}
					System.out.println("Update Victim? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter victim: ");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals("")||str.toString().contains("-"))
							throw new InvalidDataException();
						
						for(Victims v:VictimController.victimList) {
							if(v.getVictimId()==Integer.parseInt(str.toString())) {
								t1.setVictim(v);
							}
						}
					}
					System.out.println("Update Suspect? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter suspect Id: ");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals("")||str.toString().contains("-"))
							throw new InvalidDataException();
						
						for(Suspects s:SuspectController.suspectsList) {
							if(s.getSuspectId()==Integer.parseInt(str.toString())) {
								t1.setSuspect(s);
							}
						}
					}
					System.out.println("Update Agency? y/n");
					ch=sc.nextLine().charAt(0);
					if(ch=='y') {
						System.out.println("Enter agency Id: ");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals("")||str.toString().contains("-"))
							throw new InvalidDataException();
						
						for(LawEnforcementAgencies a:LawEnforcementAgencyController.agencyList) {
							if(a.getAgencyId()==Integer.parseInt(str.toString())) {
								t1.setAgency(a);
							}
						}
					}
					incidentDao.updateIncident(t1);
					System.out.println("Data Updated Successfully!!");
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InvalidDataException e) {
			System.err.println(e);
		}
	}
	
	/**
     * Updates the status of an incident based on the provided incident ID.
     *
     * @param id The ID of the incident whose status is to be updated.
     */
	public void updateIncidentStatus(int id) {
		try {
			StringBuffer str=new StringBuffer("");
			System.out.println("Enter Updated Status:");
			str=str.append(bufferReader.readLine());
			incidentDao.updateIncidentStatus(id,str.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Searches for incidents based on the provided criteria and displays the results.
     *
     * @param criteria The search criteria (e.g., "id", "type", "date", "location").
     */
	public void searchIncidents(String criteria) {
				try {
					StringBuffer str=new StringBuffer("");
					boolean valueFound=false;
					if(criteria.equalsIgnoreCase("id")) {
						System.out.println("Enter Incident Id:");
						str=str.append(bufferReader.readLine());
						if(str.toString().equals("")||str.toString().contains("-"))
							throw new InvalidDataException();
			
						for(Incidents i:incidentList) {
							if(i.getIncidentId()==Integer.parseInt(str.toString())) {
								System.out.println(i);
								valueFound=true;
								return;
							}
						}
						if(valueFound==false) {
							System.out.println("No records found!!");
						}
					}
					else if(criteria.equalsIgnoreCase("type")) {
						System.out.println("Enter Incident type:");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						for(Incidents i:incidentList) {
							if(i.getIncidentType().equalsIgnoreCase(str.toString())) {
								System.out.println(i);
								valueFound=true;
							}
						}
						if(valueFound==false) {
							System.out.println("No records found!!");
						}
					}
					else if(criteria.equalsIgnoreCase("date")) {
						System.out.println("Enter Incident date(yyyy-mm-dd):");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						for(Incidents i:incidentList) {
							if(i.getIncidentDate().isEqual(LocalDate.parse(str.toString()))) {
								System.out.println(i);
								valueFound=true;
							}
						}
						if(valueFound==false) {
							System.out.println("No records found!!");
						}
					}else if(criteria.equalsIgnoreCase("location")) {
						System.out.println("Enter Incident Location:");
						str.setLength(0);
						str=str.append(bufferReader.readLine());
						if(str.toString().equals(""))
							throw new InvalidDataException();
						for(Incidents i:incidentList) {
							if(i.getLocation().equalsIgnoreCase(str.toString())) {
								System.out.println(i);
								valueFound=true;
							}
						}
						if(valueFound==false) {
							System.out.println("No records found!!");
						}
					}else {
						System.out.println("Enter a valid criteria");
					}
				}catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	/**
     * Displays all incidents stored in the incidentList.
     */
	public void viewIncidents() {
		for(Incidents i:incidentList) {
			System.out.println(i);
		}
		//idao.displayAllIncidents();
	}
	
	 /**
     * Retrieves and displays details of a specific incident based on the provided incident ID.
     *
     * @param id The ID of the incident to be retrieved and displayed.
     * @throws RecordNotFoundException If the incident with the provided ID is not found.
     */
	public void getIncidentById(int id) throws RecordNotFoundException {
		boolean isAvailable=false;
		for(Incidents i:incidentList) {
			if(i.getIncidentId()==id) {
				System.out.println(i);
				return;
			}
		}
		if(isAvailable==false)
			throw new RecordNotFoundException();
	}
}
