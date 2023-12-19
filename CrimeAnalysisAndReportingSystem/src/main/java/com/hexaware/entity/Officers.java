package com.hexaware.entity;

/**
 * The {@code Officers} class represents a law enforcement officer with unique
 * identifier, name, badge number, rank, contact information, and associated agency.
 * <p>
 * This class provides methods to get and set the properties of an officer,
 * as well as a toString method for obtaining a string representation of the object.
 * </p>
 * <p>
 * Example usage:
 * <pre>
 * LawEnforcementAgencies agency = new LawEnforcementAgencies(1, "Police Department", "City", "123-456-7890");
 * Officers officer = new Officers(101, "John", "Doe", "12345", "Sergeant", "987-654-3210", agency);
 * System.out.println(officer.toString());
 * </pre>
 * </p>
 */
public class Officers {

    /**
     * The unique identifier of the officer.
     */
    private int officerId;

    /**
     * The first name of the officer.
     */
    private String firstName;

    /**
     * The last name of the officer.
     */
    private String lastName;

    /**
     * The badge number of the officer.
     */
    private String badgeNo;

    /**
     * The rank of the officer.
     */
    private String rank;

    /**
     * The contact information of the officer.
     */
    private String contactInfo;

    /**
     * The law enforcement agency associated with the officer.
     */
    private LawEnforcementAgencies agency;

    /**
     * Default constructor for the {@code Officers} class.
     */
    public Officers() {
        super();
    }

    /**
     * Parameterized constructor for the {@code Officers} class.
     *
     * @param officerId   The unique identifier of the officer.
     * @param firstName   The first name of the officer.
     * @param lastName    The last name of the officer.
     * @param badgeNo     The badge number of the officer.
     * @param rank        The rank of the officer.
     * @param contactInfo The contact information of the officer.
     * @param agency      The law enforcement agency associated with the officer.
     */
    public Officers(int officerId, String firstName, String lastName, String badgeNo, String rank,
                    String contactInfo, LawEnforcementAgencies agency) {
        super();
        this.officerId = officerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.badgeNo = badgeNo;
        this.rank = rank;
        this.contactInfo = contactInfo;
        this.agency = agency;
    }

    /**
     * Get the unique identifier of the officer.
     *
     * @return The officer's unique identifier.
     */
    public int getOfficerId() {
        return officerId;
    }

    /**
     * Set the unique identifier of the officer.
     *
     * @param officerId The new unique identifier for the officer.
     */
    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    /**
     * Get the first name of the officer.
     *
     * @return The first name of the officer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the officer.
     *
     * @param firstName The new first name for the officer.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the officer.
     *
     * @return The last name of the officer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the officer.
     *
     * @param lastName The new last name for the officer.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the badge number of the officer.
     *
     * @return The badge number of the officer.
     */
    public String getBadgeNo() {
        return badgeNo;
    }

    /**
     * Set the badge number of the officer.
     *
     * @param badgeNo The new badge number for the officer.
     */
    public void setBadgeNo(String badgeNo) {
        this.badgeNo = badgeNo;
    }

    /**
     * Get the rank of the officer.
     *
     * @return The rank of the officer.
     */
    public String getRank() {
        return rank;
    }

    /**
     * Set the rank of the officer.
     *
     * @param rank The new rank for the officer.
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Get the contact information of the officer.
     *
     * @return The contact information of the officer.
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Set the contact information of the officer.
     *
     * @param contactInfo The new contact information for the officer.
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * Get the law enforcement agency associated with the officer.
     *
     * @return The law enforcement agency associated with the officer.
     */
    public LawEnforcementAgencies getAgency() {
        return agency;
    }

    /**
     * Set the law enforcement agency associated with the officer.
     *
     * @param agency The new law enforcement agency for the officer.
     */
    public void setAgency(LawEnforcementAgencies agency) {
        this.agency = agency;
    }

    /**
     * Returns a string representation of the {@code Officers} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Officers [officerId=" + officerId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", badgeNo=" + badgeNo + ", rank=" + rank + ", contactInfo=" + contactInfo + ", agency=" + agency + "]";
    }
}
