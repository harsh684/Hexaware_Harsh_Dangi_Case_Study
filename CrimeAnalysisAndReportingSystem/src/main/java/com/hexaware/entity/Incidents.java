package com.hexaware.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents an Incident object with attributes such as incidentId, incidentType, incidentDate, location,
 * description, status, victim, suspect, and agency.
 */
public class Incidents {

    private int incidentId;
    private String incidentType;
    private LocalDate incidentDate;
    private String location;
    private String description;
    private String status;
    private Victims victim;
    private Suspects suspect;
    private LawEnforcementAgencies agency;

    /**
     * Default constructor for Incidents.
     */
    public Incidents() {
        super();
    }

    /**
     * Parameterized constructor for Incidents.
     *
     * @param incidentId    The unique identifier for the incident.
     * @param incidentType  The type of the incident.
     * @param incidentDate  The date of the incident.
     * @param location      The location of the incident.
     * @param description   The description of the incident.
     * @param status        The status of the incident.
     * @param victim        The victim associated with the incident.
     * @param suspect       The suspect associated with the incident.
     * @param agency        The law enforcement agency involved in the incident.
     */
    public Incidents(int incidentId, String incidentType, LocalDate incidentDate, String location,
                     String description, String status, Victims victim, Suspects suspect, LawEnforcementAgencies agency) {
        super();
        this.incidentId = incidentId;
        this.incidentType = incidentType;
        this.incidentDate = incidentDate;
        this.location = location;
        this.description = description;
        this.status = status;
        this.victim = victim;
        this.suspect = suspect;
        this.agency = agency;
    }

    /**
     * Retrieves the incidentId.
     *
     * @return The incidentId.
     */
    public int getIncidentId() {
        return incidentId;
    }

    /**
     * Sets the incidentId.
     *
     * @param incidentId The incidentId to set.
     */
    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    /**
     * Retrieves the incidentType.
     *
     * @return The incidentType.
     */
    public String getIncidentType() {
        return incidentType;
    }

    /**
     * Sets the incidentType.
     *
     * @param incidentType The incidentType to set.
     */
    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    /**
     * Retrieves the incidentDate.
     *
     * @return The incidentDate.
     */
    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    /**
     * Sets the incidentDate.
     *
     * @param incidentDate The incidentDate to set.
     */
    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    /**
     * Retrieves the location.
     *
     * @return The location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location.
     *
     * @param location The location to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Retrieves the description.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the status.
     *
     * @return The status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the victim.
     *
     * @return The victim.
     */
    public Victims getVictim() {
        return victim;
    }

    /**
     * Sets the victim.
     *
     * @param victim The victim to set.
     */
    public void setVictim(Victims victim) {
        this.victim = victim;
    }

    /**
     * Retrieves the suspect.
     *
     * @return The suspect.
     */
    public Suspects getSuspect() {
        return suspect;
    }

    /**
     * Sets the suspect.
     *
     * @param suspect The suspect to set.
     */
    public void setSuspect(Suspects suspect) {
        this.suspect = suspect;
    }

    /**
     * Retrieves the agency.
     *
     * @return The agency.
     */
    public LawEnforcementAgencies getAgency() {
        return agency;
    }

    /**
     * Sets the agency.
     *
     * @param agency The agency to set.
     */
    public void setAgency(LawEnforcementAgencies agency) {
        this.agency = agency;
    }

    /**
     * Returns a string representation of the Incidents object.
     *
     * @return A string representation of the Incidents object.
     */
    @Override
    public String toString() {
        return "Incident [incidentId=" + incidentId + ", incidentType=" + incidentType + ", incidentDate="
                + incidentDate + ", location=" + location + ", description=" + description + ", status=" + status
                + ", \nvictim=" + victim + ", \nsuspect=" + suspect + ", \nagency=" + agency + "]\n";
    }
}

