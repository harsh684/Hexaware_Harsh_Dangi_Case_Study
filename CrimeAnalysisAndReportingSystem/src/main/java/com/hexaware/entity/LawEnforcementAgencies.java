package com.hexaware.entity;

/**
 * The {@code LawEnforcementAgencies} class represents a law enforcement agency with its
 * unique identifier, name, jurisdiction, and contact information.
 * <p>
 * This class provides methods to get and set the properties of a law enforcement agency,
 * as well as a toString method for obtaining a string representation of the object.
 * </p>
 * <p>
 * Example usage:
 * <pre>
 * LawEnforcementAgencies agency = new LawEnforcementAgencies(1, "Police Department", "City", "123-456-7890");
 * System.out.println(agency.toString());
 * </pre>
 * </p>
 */
public class LawEnforcementAgencies {

    /**
     * The unique identifier of the law enforcement agency.
     */
    private int agencyId;

    /**
     * The name of the law enforcement agency.
     */
    private String agencyName;

    /**
     * The jurisdiction served by the law enforcement agency.
     */
    private String jurisdiction;

    /**
     * The contact information for the law enforcement agency.
     */
    private String contactInfo;

    /**
     * Default constructor for the {@code LawEnforcementAgencies} class.
     */
    public LawEnforcementAgencies() {
        super();
    }

    /**
     * Parameterized constructor for the {@code LawEnforcementAgencies} class.
     *
     * @param agencyId     The unique identifier of the law enforcement agency.
     * @param agencyName   The name of the law enforcement agency.
     * @param jurisdiction The jurisdiction served by the law enforcement agency.
     * @param contactInfo  The contact information for the law enforcement agency.
     */
    public LawEnforcementAgencies(int agencyId, String agencyName, String jurisdiction, String contactInfo) {
        super();
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.jurisdiction = jurisdiction;
        this.contactInfo = contactInfo;
    }

    /**
     * Get the unique identifier of the law enforcement agency.
     *
     * @return The agency's unique identifier.
     */
    public int getAgencyId() {
        return agencyId;
    }

    /**
     * Set the unique identifier of the law enforcement agency.
     *
     * @param agencyId The new unique identifier for the agency.
     */
    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * Get the name of the law enforcement agency.
     *
     * @return The name of the agency.
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * Set the name of the law enforcement agency.
     *
     * @param agencyName The new name for the agency.
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * Get the jurisdiction served by the law enforcement agency.
     *
     * @return The jurisdiction served by the agency.
     */
    public String getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Set the jurisdiction served by the law enforcement agency.
     *
     * @param jurisdiction The new jurisdiction for the agency.
     */
    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    /**
     * Get the contact information for the law enforcement agency.
     *
     * @return The contact information for the agency.
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Set the contact information for the law enforcement agency.
     *
     * @param contactInfo The new contact information for the agency.
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * Returns a string representation of the {@code LawEnforcementAgencies} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "LawEnforcementAgencies [agencyId=" + agencyId + ", agencyName=" + agencyName
                + ", jurisdiction=" + jurisdiction + ", contactInfo=" + contactInfo + "]";
    }
}