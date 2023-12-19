package com.hexaware.entity;

/**
 * Represents an Evidence object with attributes such as evidenceId, description, locationFound, and incidentId.
 */
public class Evidence {

    private int evidenceId;
    private String description;
    private String locationFound;
    private int incidentId;

    /**
     * Default constructor for Evidence.
     */
    public Evidence() {
        super();
    }

    /**
     * Parameterized constructor for Evidence.
     *
     * @param evidenceId     The unique identifier for the evidence.
     * @param description    The description of the evidence.
     * @param locationFound  The location where the evidence was found.
     * @param incidentId     The identifier of the incident related to the evidence.
     */
    public Evidence(int evidenceId, String description, String locationFound, int incidentId) {
        super();
        this.evidenceId = evidenceId;
        this.description = description;
        this.locationFound = locationFound;
        this.incidentId = incidentId;
    }

    /**
     * Retrieves the evidenceId.
     *
     * @return The evidenceId.
     */
    public int getEvidenceId() {
        return evidenceId;
    }

    /**
     * Sets the evidenceId.
     *
     * @param evidenceId The evidenceId to set.
     */
    public void setEvidenceId(int evidenceId) {
        this.evidenceId = evidenceId;
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
     * Retrieves the locationFound.
     *
     * @return The locationFound.
     */
    public String getLocationFound() {
        return locationFound;
    }

    /**
     * Sets the locationFound.
     *
     * @param locationFound The locationFound to set.
     */
    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
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
     * Returns a string representation of the Evidence object.
     *
     * @return A string representation of the Evidence object.
     */
    @Override
    public String toString() {
        return "Evidence [evidenceId=" + evidenceId + ", description=" + description +
               ", locationFound=" + locationFound + ", incidentId=" + incidentId + "]";
    }
}
