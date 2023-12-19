package com.hexaware.entity;

import java.time.LocalDate;

/**
 * The {@code Victims} class represents an individual who has been harmed or suffered
 * in some way as a result of a crime, providing details such as name, date of birth,
 * gender, address, and contact information.
 * <p>
 * This class provides methods to get and set the properties of a victim,
 * as well as a toString method for obtaining a string representation of the object.
 * </p>
 * <p>
 * Example usage:
 * <pre>
 * Victims victim = new Victims(201, "Jane", "Doe", LocalDate.of(1990, 8, 21),
 *                             "Female", "123 Main St, Cityville", "555-5678");
 * System.out.println(victim.toString());
 * </pre>
 * </p>
 */
public class Victims {

    /**
     * The unique identifier of the victim.
     */
    private int victimId;

    /**
     * The first name of the victim.
     */
    private String firstName;

    /**
     * The last name of the victim.
     */
    private String lastName;

    /**
     * The date of birth of the victim.
     */
    private LocalDate dob;

    /**
     * The gender of the victim.
     */
    private String gender;

    /**
     * The address of the victim.
     */
    private String address;

    /**
     * The contact phone number of the victim.
     */
    private String phone;

    /**
     * Default constructor for the {@code Victims} class.
     */
    public Victims() {
        super();
    }

    /**
     * Parameterized constructor for the {@code Victims} class.
     *
     * @param victimId The unique identifier of the victim.
     * @param firstName The first name of the victim.
     * @param lastName The last name of the victim.
     * @param dob The date of birth of the victim.
     * @param gender The gender of the victim.
     * @param address The address of the victim.
     * @param phone The contact phone number of the victim.
     */
    public Victims(int victimId, String firstName, String lastName, LocalDate dob, String gender, String address,
                   String phone) {
        super();
        this.victimId = victimId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Get the unique identifier of the victim.
     *
     * @return The victim's unique identifier.
     */
    public int getVictimId() {
        return victimId;
    }

    /**
     * Set the unique identifier of the victim.
     *
     * @param victimId The new unique identifier for the victim.
     */
    public void setVictimId(int victimId) {
        this.victimId = victimId;
    }

    /**
     * Get the first name of the victim.
     *
     * @return The first name of the victim.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the victim.
     *
     * @param firstName The new first name for the victim.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the victim.
     *
     * @return The last name of the victim.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the victim.
     *
     * @param lastName The new last name for the victim.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the date of birth of the victim.
     *
     * @return The date of birth of the victim.
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Set the date of birth of the victim.
     *
     * @param dob The new date of birth for the victim.
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Get the gender of the victim.
     *
     * @return The gender of the victim.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the gender of the victim.
     *
     * @param gender The new gender for the victim.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get the address of the victim.
     *
     * @return The address of the victim.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the victim.
     *
     * @param address The new address for the victim.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the contact phone number of the victim.
     *
     * @return The contact phone number of the victim.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the contact phone number of the victim.
     *
     * @param phone The new contact phone number for the victim.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns a string representation of the {@code Victims} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Victims [victimId=" + victimId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
                + ", gender=" + gender + ", address=" + address + ", phone=" + phone + "]";
    }
}
