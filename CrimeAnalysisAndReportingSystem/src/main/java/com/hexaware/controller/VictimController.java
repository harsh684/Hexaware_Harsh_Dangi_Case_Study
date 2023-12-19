package com.hexaware.controller;

import com.hexaware.dao.VictimsDao;
import com.hexaware.entity.Victims;
import com.hexaware.exception.DuplicateDataException;
import com.hexaware.exception.InvalidDataException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code VictimController} class serves as a controller for managing a list of victims,
 * allowing interactions with a data access object ({@code VictimsDao}) 
 * to populate and display victim information.
 * It provides methods to populate the list, add new 
 * victim details, and display information about the victims.
 */
public class VictimController {

	 /**
     * The list containing instances of {@code Victims}.
     */
	public static List<Victims> victimList = new ArrayList<Victims>();
	
	/**
     * Input stream reader for reading input from the console.
     */
	InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	
	/**
     * Buffered reader for efficient reading of input.
     */
	BufferedReader bufferReader = new BufferedReader(inputStreamReader);
	
	/**
     * Data Access Object for {@link Victim}.
     */
	VictimsDao victimDataAccessObject = new VictimsDao();
	
	/**
     * Instance for the class {@link Victim}.
     */
	Victims victim;
	
   /**
     * Populates the {@code victimList} by fetching victim information from the database
     * using the associated data access object.
     */
	public void putVictimsToArray() {
		victimDataAccessObject.putVictimsToArray();
	}
	
	/**
     * Adds a new victim to the {@code victimList} and stores the information in the database.
     * Prompts the user to enter victim details such
     *  as ID, name, date of birth, gender, address, and contact information.
     * Validates the input data to ensure correctness.
     */
	public void addVictim() {
		StringBuffer str=new StringBuffer("");
		victim=new Victims();
		try {
			System.out.println("Enter Victim Id:");
			str=str.append(bufferReader.readLine());
			if(str.toString().equals("")||Integer.parseInt(str.toString())<0)
				throw new InvalidDataException();
			victim.setVictimId(Integer.parseInt(str.toString()));
			
			System.out.println("Enter Victim's First Name:");
			str.setLength(0);
			str=str.append(str.toString());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			victim.setFirstName(str.toString());
			
			System.out.println("Enter Victim's Last Name:");
			str.setLength(0);
			str=str.append(str.toString());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			victim.setLastName(str.toString());
			
			System.out.println("Enter Victim's Date of Birth:");
			str.setLength(0);
			str=str.append(str.toString());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			victim.setDob(LocalDate.parse(str.toString()));
			
			System.out.println("Enter Victim's Gender:");
			str.setLength(0);
			str=str.append(str.toString());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			victim.setGender(str.toString());
			
			System.out.println("Enter Victim's Address:");
			str.setLength(0);
			str=str.append(str.toString());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			victim.setAddress(str.toString());
			
			System.out.println("Enter Victim's Contact Info:");
			str.setLength(0);
			str=str.append(str.toString());
			if(str.toString().equals(""))
				throw new InvalidDataException();
			victim.setPhone(str.toString());
			
			boolean containsObject = victimList.stream()
	                .anyMatch(obj -> obj.getVictimId()==victim.getVictimId());
			
			
			if(containsObject) {
				throw new DuplicateDataException();
			}
			
			victimList.add(victim);
			victimDataAccessObject.addVictim(victim);
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (InvalidDataException e) {
			System.err.println(e);
		} catch (DuplicateDataException e) {
			System.err.println(e);
		}
		
	}
	
 /**
     * Displays information about the victims in the {@code victimList}.
     */
	public void displayVictims(){
		for(Victims v:victimList) {
			System.out.println(v);
		}
	}
}
