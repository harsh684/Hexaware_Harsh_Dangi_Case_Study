package com.hexaware.dao;

import com.hexaware.entity.Incidents;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface for the Incident DAO (Data Access Object).
 */
public interface IncidentDaoInterface {

  /**
  * Retrieves and populates the incidents data into an array.
  */
  public void putIncidentsToArray();

  /**
   * Inserts a new incident into the database.
   *
   * @param id          The ID of the incident.
   * @param type        The type of the incident.
   * @param date        The date of the incident.
   * @param location    The location of the incident.
   * @param description The description of the incident.
   * @param status      The status of the incident.
   * @param victimId    The ID of the victim associated with the incident.
   * @param suspectId   The ID of the suspect associated with the incident.
   * @param agencyId    The ID of the law enforcement agency associated with the incident.
   * @return True if the incident is successfully inserted, false otherwise.
   */
  public boolean insertIncident(int id, String type, LocalDate date, 
      String location, String description,
                                String status, int victimId, int suspectId, int agencyId);

  /**
   * Displays details of a specific incident.
   *
   * @param id The ID of the incident.
   */
  public void displayIncident(int id);

  /**
   * Displays details of all incidents.
   */
  public void displayAllIncidents();

  /**
 * Retrieves incidents that occurred within a specified date range.
 *
 * @param startDate The start date of the range.
 * @param endDate   The end date of the range.
 * @return List of incidents within the specified date range.
 */
  public List<Incidents> getIncidentsInDateRange(
      LocalDate startDate, 
      LocalDate endDate);

  /**
 * Updates the details of an incident in the database.
 *
 * @param incident The incident object with updated details.
 */
  public void updateIncident(Incidents incident);

  /**
 * Updates the status of an incident in the database.
 *
 * @param id     The ID of the incident.
 * @param status The new status of the incident.
 * @return True if the status is successfully updated, false otherwise.
 */
  public boolean updateIncidentStatus(int id, String status);

}
