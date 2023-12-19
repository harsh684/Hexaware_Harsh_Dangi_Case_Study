package com.hexaware.entity;

import java.time.LocalDate;

/**
 * The {@code Suspects} class represents a person suspected of involvement in a crime,
 * containing details such as name, date of birth, gender, and contact information.
 * <p>
 * This class provides methods to get and set the properties of a suspect,
 * as well as a toString method for obtaining a string representation of the object.
 * </p>
 * <p>
 * Example usage:
 * <pre>
 * Suspects suspect = new Suspects(101, "John", "Doe", LocalDate.of(1985, 5, 15), "Male", "555-1234");
 * System.out.println(suspect.toString());
 * </pre>
 * </p>
 */
public class Suspects {

    /**
     * The unique identifier of the suspect.
     */
    private int suspectId;

    /**
     * The first name of the suspect.
     */
    private String firstName;

    /**
     * The last name of the suspect.
     */
    private String lastName;

    /**
     * The date of birth of the suspect.
     */
    private LocalDate dob;

    /**
     * The gender of the suspect.
     */
    private String gender;

    /**
     * Contact information of the suspect.
     */
    private String contactInfo;

    /**
     * Default constructor for the {@code Suspects} class.
     */
    public Suspects() {
        super();
    }

    /**
     * Parameterized constructor for the {@code Suspects} class.
     *
     * @param suspectId   The unique identifier of the suspect.
     * @param firstName   The first name of the suspect.
     * @param lastName    The last name of the suspect.
     * @param dob         The date of birth of the suspect.
     * @param gender      The gender of the suspect.
     * @param contactInfo Contact information of the suspect.
     */
    public Suspects(int suspectId, String firstName, String lastName, LocalDate dob, String gender,
                    String contactInfo) {
        super();
        this.suspectId = suspectId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.contactInfo = contactInfo;
    }

    /**
     * Get the unique identifier of the suspect.
     *
     * @return The suspect's unique identifier.
     */
    public int getSuspectId() {
        return suspectId;
    }

    /**
     * Set the unique identifier of the suspect.
     *
     * @param suspectId The new unique identifier for the suspect.
     */
    public void setSuspectId(int suspectId) {
        this.suspectId = suspectId;
    }

    /**
     * Get the first name of the suspect.
     *
     * @return The first name of the suspect.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the suspect.
     *
     * @param firstName The new first name for the suspect.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the suspect.
     *
     * @return The last name of the suspect.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the suspect.
     *
     * @param lastName The new last name for the suspect.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the date of birth of the suspect.
     *
     * @return The date of birth of the suspect.
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Set the date of birth of the suspect.
     *
     * @param dob The new date of birth for the suspect.
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Get the gender of the suspect.
     *
     * @return The gender of the suspect.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the gender of the suspect.
     *
     * @param gender The new gender for the suspect.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get the contact information of the suspect.
     *
     * @return Contact information of the suspect.
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Set the contact information of the suspect.
     *
     * @param contactInfo The new contact information for the suspect.
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * Returns a string representation of the {@code Suspects} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Suspects [suspectId=" + suspectId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
                + dob + ", gender=" + gender + ", contactInfo=" + contactInfo + "]";
    }
}
