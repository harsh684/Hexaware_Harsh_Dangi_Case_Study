package com.hexaware.entity;

/**
 * Represents a Cases object with attributes such as caseId, caseDescription, and relatedIncidents.
 */
public class Cases {

    private int caseId;
    private String caseDescription;
    private Incidents relatedIncidents;

    /**
     * Default constructor for Cases.
     */
    public Cases() {
        super();
    }

    /**
     * Parameterized constructor for Cases.
     *
     * @param caseId           The unique identifier for the case.
     * @param caseDescription  The description of the case.
     * @param relatedIncidents The incidents related to the case.
     */
    public Cases(int caseId, String caseDescription, Incidents relatedIncidents) {
        super();
        this.caseId = caseId;
        this.caseDescription = caseDescription;
        this.relatedIncidents = relatedIncidents;
    }

    /**
     * Retrieves the caseId.
     *
     * @return The caseId.
     */
    public int getCaseId() {
        return caseId;
    }

    /**
     * Sets the caseId.
     *
     * @param caseId The caseId to set.
     */
    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    /**
     * Retrieves the caseDescription.
     *
     * @return The caseDescription.
     */
    public String getCaseDescription() {
        return caseDescription;
    }

    /**
     * Sets the caseDescription.
     *
     * @param caseDescription The caseDescription to set.
     */
    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    /**
     * Retrieves the relatedIncidents.
     *
     * @return The relatedIncidents.
     */
    public Incidents getRelatedIncidents() {
        return relatedIncidents;
    }

    /**
     * Sets the relatedIncidents.
     *
     * @param relatedIncidents The relatedIncidents to set.
     */
    public void setRelatedIncidents(Incidents relatedIncidents) {
        this.relatedIncidents = relatedIncidents;
    }

    /**
     * Returns a string representation of the Cases object.
     *
     * @return A string representation of the Cases object.
     */
    @Override
    public String toString() {
        return "Cases [caseId=" + caseId + ", caseDescription=" + caseDescription +
               ",\nrelatedIncident=" + relatedIncidents + "]\n";
    }
}

