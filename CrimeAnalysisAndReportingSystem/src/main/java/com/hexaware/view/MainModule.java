package com.hexaware.view;

import com.hexaware.controller.CaseController;
import com.hexaware.controller.IncidentController;
import com.hexaware.controller.LawEnforcementAgencyController;
import com.hexaware.controller.OfficerController;
import com.hexaware.controller.ReportController;
import com.hexaware.controller.SuspectController;
import com.hexaware.controller.VictimController;
import com.hexaware.exception.IncidentNumberNotFoundException;
import com.hexaware.exception.RecordNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

/**Main method to interact with the user and provide options.
 * 
 *
 */
public class MainModule {

  /**
     * Main method to execute the Crime Analysis and Reporting System.
     *
     * @param args Command-line arguments.
     * @throws RecordNotFoundException If a record is not found.
     */
  public static void main(String[] args){
    try {
    	// Controller instances for various entities
        IncidentController incidentController = new IncidentController();
        VictimController victimController=new VictimController();
        SuspectController suspectController=new SuspectController();
        LawEnforcementAgencyController agencyController=new LawEnforcementAgencyController();
        CaseController caseController=new CaseController();
        OfficerController officerController=new OfficerController();
        ReportController reportController=new ReportController();
        int l;

        // Initializing data arrays for entities
        victimController.putVictimsToArray();
        suspectController.putSuspectsToArray();
        agencyController.putAgenciesToArray();
        incidentController.putIncidentsToArray();
        caseController.putCasesToArray();
        officerController.putOfficersToArray();
        reportController.putReportsToArray();

        // Main menu options
        System.out.println("---------------");
        System.out.println("Crime Analysis and Reporting System");
        System.out.println("---------------");
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
          System.out.println("Main Menu:");
          System.out.println("0. Exit\n"
              + "1. Incidents Section\n"
              + "2. Cases Section\n"
              + "3. Officers Section\n"
              + "4. Reports Section\n"
              + "5. Victims Section\n"
              + "6. Suspects Section\n"
              + "7. Agency Section\n");

          System.out.println("Please enter your choice:");
          ch = sc.nextInt();
          switch (ch) {

            case 0:break;
            
            case 1:
              // Incidents section menu
              System.out.println("0. Exit\n"
                  + "1. View Incidents\n"
                  + "2. Add Incidents\n"
                  + "3. Search Incidents in Date Range\n"
                  + "4. Search Incidents by criteria\n"
                  + "5. Update Incident Status \n"
                  + "6. Update Incident\n"
                  + "7. Get Incident By Id");
              System.out.println("Enter your choice: ");
              l = sc.nextInt();

              switch (l) {
                case 0:break;
                
                case 1:incidentController.viewIncidents(); 
                break;

                case 2:incidentController.addIncidents();
                break;

                case 3:System.out.println("Enter Start Date and End Date(yyyy-mm-dd): ");
                       incidentController.getIncidentsDateRange(LocalDate.parse(sc.next()),
                              LocalDate.parse(sc.next()));
                       break;
                
                case 4:System.out.println("Enter your criteria (id/type/date(yyyy-mm-dd)/location)");
                       incidentController.searchIncidents(sc.next());
                       break;
                
                case 5:System.out.println("Enter Incident Id:");
                       incidentController.updateIncidentStatus(sc.nextInt());
                       break;
                
                case 6:System.out.println("Enter incident id:");
                       incidentController.updateIncident(sc.nextInt());
                       break;
                
                case 7:System.out.println("Enter incident id:");
                       incidentController.getIncidentById(sc.nextInt());
                       break;

                default:System.out.println("Enter a valid option");
                        break;
              }
              break;

            case 2:
              // Cases section menu
              System.out.println("0. Exit\n"
                   + "1. Add a Case\n"
                   + "2. Update a Case\n"
                   + "3. Display All Cases\n"
                   + "4. Get Case Details");
         System.out.println("Enter your choice: ");
         l=sc.nextInt();
         switch(l) {
         	case 0:break;
         	
         	case 1:	caseController.addCase();
         			break;
    	
        	case 2:	System.out.println("Enter case Id: ");
        			caseController.updateCase(sc.nextInt());
        			break;
        			
         	case 3:	caseController.getAllCases();
         			break;

         	case 4:	System.out.println("Enter case Id: ");
    			caseController.getCase(sc.nextInt());
    			break;
         			
         	default:System.out.println("Enter a valid option!!");
         			break;
         }
         break;

         case 3:
        	 //Officers menu section
         System.out.println("0. Exit\n"
         		+ "1. Register an Officer\n"
         		+ "2. Show All Officers\n"
         		+ "3. Get Officer By Id");
         l=sc.nextInt();
         switch(l) {
         	case 0:break;

         	case 1:officerController.addOfficer();
         	break;
    	
         	case 2:officerController.displayOfficers();
         	break;
    	
         	case 3:System.out.println("Enter Officer Id:");
         		officerController.getOfficerById(sc.nextInt());
         	break;
    	
         	default:System.out.println("Enter a valid option!");
         	break;
         }
         break;

        case 4://Reports menu section
        	System.out.println("0. Exit\n"
        		+ "1. Add Report\n"
        		+ "2. Show Reports\n"
        		+ "3. Get Report By Id");
        l=sc.nextInt();
        switch(l) {
        	case 0:
        		break;
        		
        	case 1:reportController.addReport();
        		break;
        	
        	case 2:reportController.displayReports();
        		break;
        		
        	case 3:System.out.println("Enter Report Id");
        		reportController.getReportById(sc.nextInt());
        	break;
        		
        	default:System.out.println("Enter a valid option:");
        	break;
        }
        break;

    		case 5://Victim menu section
    			System.out.println("0. Exit\n"
    				+ "1. Add a Victim\n"
    				+ "2. Show all Victims\n");
    		l=sc.nextInt();
    		switch(l) {
    			case 0:break;
    			
    			case 1:victimController.addVictim();
    			break;
    			
    			case 2:victimController.displayVictims();
    			break;
    			
    			default:System.out.println("Enter a valid option:");
    			break;
    		}
    		break;
    		
    		case 6://Suspects menu section
    			System.out.println("0. Exit\n"
    				+ "1. Add Suspect\n"
    				+ "2. Show All Suspects\n");
    		l=sc.nextInt();
    		switch(l) {
    			case 0:break;
    			
    			case 1:suspectController.addSuspect();
    			break;
    			
    			case 2:suspectController.showSuspects();
    			break;
    			
    			default:System.out.println("Enter a valid option:");
    			break;
    		}
    		break;
    		
    		case 7://Law Enforcement Agencies menu Section
    			System.out.println("0. Exit\n"
    				+ "1. Add Agency\n"
    				+ "2. Show All Agencies\n");
    		l=sc.nextInt();
    		switch(l) {
    			case 0:break;
    			
    			case 1:agencyController.addAgency();
    			break;
    			
    			case 2:agencyController.showAllAgencies();
    			break;
    			
    			default:System.out.println("Enter a valid option:");
    			break;
    		}
    		break;
    		
    		default:System.out.println("Enter a valid option:");
    			break;
          }
        } while (ch != 0);
    }catch(RecordNotFoundException e) {
    	System.err.println(e);
    }catch(IncidentNumberNotFoundException e) {
    	System.err.println();
    }
  }
}
