package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.hexaware.controller.IncidentController;
import com.hexaware.controller.LawEnforcementAgencyController;
import com.hexaware.controller.Status;
import com.hexaware.controller.SuspectController;
import com.hexaware.controller.VictimController;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.entity.Suspects;
import com.hexaware.entity.Victims;
import com.hexaware.exception.InvalidDataException;
import com.hexaware.exception.InvalidStatusException;
import com.hexaware.util.DbPropertyUtil;

/**
 * DAO (Data Access Object) class for Incidents.
 * Manages database operations related to Incidents.
 */
public class IncidentDao {

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Incidents incident;

    /**
     * Retrieves and populates Incidents data into an array.
     */
    public void putIncidentsToArray() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Incidents");
            while (resultSet.next()) {
                incident = new Incidents();
                incident.setIncidentId(resultSet.getInt(1));
                incident.setIncidentType(resultSet.getString(2));
                LocalDate ldate = resultSet.getDate(3).toLocalDate();
                incident.setIncidentDate(ldate);
                incident.setLocation(resultSet.getString(4));
                incident.setDescription(resultSet.getString(5));
                incident.setStatus(resultSet.getString(6));

                // Find the related victim from the victim list
                for (Victims v : VictimController.victimList) {
                    if (v.getVictimId() == resultSet.getInt(7)) {
                        incident.setVictim(v);
                    }
                }

                // Find the related suspect from the suspect list
                for (Suspects s : SuspectController.suspectsList) {
                    if (s.getSuspectId() == resultSet.getInt(8)) {
                        incident.setSuspect(s);
                    }
                }

                // Find the related agency from the agency list
                for (LawEnforcementAgencies la : LawEnforcementAgencyController.agencyList) {
                    if (la.getAgencyId() == resultSet.getInt(9)) {
                        incident.setAgency(la);
                    }
                }

                IncidentController.incidentList.add(incident);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts a new Incident into the database.
     *
     * @param id          The incident ID.
     * @param type        The incident type.
     * @param date        The incident date.
     * @param location    The incident location.
     * @param description The incident description.
     * @param status      The incident status.
     * @param victimId    The ID of the related victim.
     * @param suspectId   The ID of the related suspect.
     * @param agencyId    The ID of the related agency.
     * @return True if the incident is inserted successfully, false otherwise.
     */
    public boolean insertIncident(int id, String type, LocalDate date, String location, String description,
                                  String status, int victimId, int suspectId, int agencyId) {
        boolean isInserted = false;
        try {
            // Validate input data
            if (id < 0 || victimId < 0 || suspectId < 0 || agencyId < 0 || type.equals("") || date == null
                    || location.equals("") || description.equals(""))
                throw new InvalidDataException();

            // Validate incident status
            if (!status.equalsIgnoreCase("OPEN") && !status.equalsIgnoreCase("CLOSED")
                    && !status.equalsIgnoreCase("UNDER_INVESTIGATION"))
                throw new InvalidDataException();

            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into Incidents values(?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, type);
            preparedStatement.setDate(3, Date.valueOf(date));
            preparedStatement.setString(4, location);
            preparedStatement.setString(5, description);
            preparedStatement.setString(6, status);
            preparedStatement.setInt(7, victimId);
            preparedStatement.setInt(8, suspectId);
            preparedStatement.setInt(9, agencyId);
            int noOfRows = preparedStatement.executeUpdate();
            isInserted = noOfRows != 0;
            System.out.println(noOfRows + " inserted successfully !!!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            System.err.println(e);
        }
        return isInserted;
    }

    /**
     * Displays the details of an incident with the given ID.
     *
     * @param id The ID of the incident to be displayed.
     */
    public void displayIncident(int id) {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            String query = "select * from Incidents where incidentid=" + id;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Incident Id: " + resultSet.getInt(1));
                System.out.println("Incident Type: " + resultSet.getString(2));
                System.out.println("Incident Date: " + resultSet.getDate(3));
                System.out.println("Incident Location: " + resultSet.getString(4));
                System.out.println("Incident Description: " + resultSet.getString(5));
                System.out.println("Incident status: " + resultSet.getString(6));
                System.out.println("Victim Id: " + resultSet.getInt(7));
                System.out.println("Suspect Id: " + resultSet.getInt(8));
                System.out.println("Agency Id: " + resultSet.getInt(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays details of all incidents in the database.
     */
    public void displayAllIncidents() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            String query = "select * from Incidents";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Incident Id: " + resultSet.getInt(1));
                System.out.println("Incident Type: " + resultSet.getString(2));
                System.out.println("Incident Date: " + resultSet.getDate(3));
                System.out.println("Incident Location: " + resultSet.getString(4));
                System.out.println("Incident Description: " + resultSet.getString(5));
                System.out.println("Incident status: " + resultSet.getString(6));
                System.out.println("Victim Id: " + resultSet.getInt(7));
                System.out.println("Suspect Id: " + resultSet.getInt(8));
                System.out.println("Agency Id: " + resultSet.getInt(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves incidents within a specified date range.
     *
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return List of Incidents within the date range.
     */
    public List<Incidents> getIncidentsInDateRange(LocalDate startDate, LocalDate endDate) {
        List<Incidents> res = new ArrayList<Incidents>();
        Incidents i;
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            String query = "select * from Incidents where incidentdate between '" + startDate + "' and '" + endDate
                    + "'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                i = new Incidents();
                i.setIncidentId(resultSet.getInt(1));
                i.setIncidentType(resultSet.getString(2));
                i.setIncidentDate(resultSet.getDate(3).toLocalDate());
                i.setLocation(resultSet.getString(4));
                i.setDescription(resultSet.getString(5));
                i

.setStatus(resultSet.getString(6));

                // Find the related victim from the victim list
                for (Victims v : VictimController.victimList) {
                    if (v.getVictimId() == resultSet.getInt(7)) {
                        i.setVictim(v);
                    }
                }

                // Find the related suspect from the suspect list
                for (Suspects s : SuspectController.suspectsList) {
                    if (s.getSuspectId() == resultSet.getInt(8)) {
                        i.setSuspect(s);
                    }
                }

                // Find the related agency from the agency list
                for (LawEnforcementAgencies la : LawEnforcementAgencyController.agencyList) {
                    if (la.getAgencyId() == resultSet.getInt(9)) {
                        i.setAgency(la);
                    }
                }

                res.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Updates an existing incident in the database.
     *
     * @param incident The Incident object with updated details.
     */
    public boolean updateIncident(Incidents incident) {
    	boolean isUpdated = false;
    	try {
            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("update Incidents set "
                    + "incidenttype='" + incident.getIncidentType() + "',incidentdate='" + Date.valueOf(incident.getIncidentDate())
                    + "',location='" + incident.getLocation() + "',incidentdesc='" + incident.getDescription()
                    + "',status='" + incident.getStatus() + "'" + ",victimid=" + incident.getVictim().getVictimId()
                    + ",suspectid=" + incident.getSuspect().getSuspectId() + ",agencyid="
                    + incident.getAgency().getAgencyId() + " where incidentid=" + incident.getIncidentId());
            
            int noOfRows = preparedStatement.executeUpdate();
            isUpdated = noOfRows != 0;
            System.out.println(noOfRows + " Updated successfully !!!");
            if (!isUpdated)
                throw new InvalidStatusException();
    	} catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidStatusException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
    	return isUpdated;
    }

    /**
     * Updates the status of an incident in the database.
     *
     * @param id     The ID of the incident to be updated.
     * @param status The new status of the incident.
     * @return True if the status is updated successfully, false otherwise.
     */
    public boolean updateIncidentStatus(int id, String status) {
        boolean isUpdated = false;
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection
                    .prepareStatement("update Incidents set status='" + status + "' where incidentId=" + id);
            int noOfRows = preparedStatement.executeUpdate();
            isUpdated = noOfRows != 0;
            System.out.println(noOfRows + " Status Updated successfully !!!");
            if (!isUpdated)
                throw new InvalidStatusException();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidStatusException e) {
            System.err.println(e);
        }

        return isUpdated;
    }
}
