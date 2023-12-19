package com.hexaware.entity;

import java.time.LocalDate;

/**
 * The {@code Reports} class represents a report generated for a specific incident
 * by a reporting officer, containing details and status.
 * <p>
 * This class provides methods to get and set the properties of a report,
 * as well as a toString method for obtaining a string representation of the object.
 * </p>
 * <p>
 * Example usage:
 * <pre>
 * Incidents incident = new Incidents(101, "Theft", LocalDate.now(), "Street A", "A theft incident occurred.", "Open", victim, suspect, agency);
 * Officers reportingOfficer = new Officers(201, "Alice", "Johnson", "98765", "Detective", "123-456-7890", agency);
 * Reports report = new Reports(301, incident, reportingOfficer, LocalDate.now(), "Details of the incident...", "Pending");
 * System.out.println(report.toString());
 * </pre>
 * </p>
 */
public class Reports {

    /**
     * The unique identifier of the report.
     */
    private int reportId;

    /**
     * The incident associated with the report.
     */
    private Incidents incident;

    /**
     * The reporting officer who generated the report.
     */
    private Officers reportingOfficer;

    /**
     * The date when the report was generated.
     */
    private LocalDate reportDate;

    /**
     * Details of the report.
     */
    private String reportDetails;

    /**
     * The status of the report (e.g., Pending, Completed).
     */
    private String reportStatus;

    /**
     * Default constructor for the {@code Reports} class.
     */
    public Reports() {
        super();
    }

    /**
     * Parameterized constructor for the {@code Reports} class.
     *
     * @param reportId         The unique identifier of the report.
     * @param incident         The incident associated with the report.
     * @param reportingOfficer The reporting officer who generated the report.
     * @param reportDate       The date when the report was generated.
     * @param reportDetails    Details of the report.
     * @param reportStatus     The status of the report.
     */
    public Reports(int reportId, Incidents incident, Officers reportingOfficer, LocalDate reportDate,
                   String reportDetails, String reportStatus) {
        super();
        this.reportId = reportId;
        this.incident = incident;
        this.reportingOfficer = reportingOfficer;
        this.reportDate = reportDate;
        this.reportDetails = reportDetails;
        this.reportStatus = reportStatus;
    }

    /**
     * Get the unique identifier of the report.
     *
     * @return The report's unique identifier.
     */
    public int getReportId() {
        return reportId;
    }

    /**
     * Set the unique identifier of the report.
     *
     * @param reportId The new unique identifier for the report.
     */
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    /**
     * Get the incident associated with the report.
     *
     * @return The incident associated with the report.
     */
    public Incidents getIncident() {
        return incident;
    }

    /**
     * Set the incident associated with the report.
     *
     * @param incident The new incident for the report.
     */
    public void setIncident(Incidents incident) {
        this.incident = incident;
    }

    /**
     * Get the reporting officer who generated the report.
     *
     * @return The reporting officer who generated the report.
     */
    public Officers getReportingOfficer() {
        return reportingOfficer;
    }

    /**
     * Set the reporting officer who generated the report.
     *
     * @param reportingOfficer The new reporting officer for the report.
     */
    public void setReportingOfficer(Officers reportingOfficer) {
        this.reportingOfficer = reportingOfficer;
    }

    /**
     * Get the date when the report was generated.
     *
     * @return The date when the report was generated.
     */
    public LocalDate getReportDate() {
        return reportDate;
    }

    /**
     * Set the date when the report was generated.
     *
     * @param reportDate The new date for the report.
     */
    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * Get details of the report.
     *
     * @return Details of the report.
     */
    public String getReportDetails() {
        return reportDetails;
    }

    /**
     * Set details of the report.
     *
     * @param reportDetails The new details for the report.
     */
    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    /**
     * Get the status of the report.
     *
     * @return The status of the report.
     */
    public String getReportStatus() {
        return reportStatus;
    }

    /**
     * Set the status of the report.
     *
     * @param reportStatus The new status for the report.
     */
    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    /**
     * Returns a string representation of the {@code Reports} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Reports [reportId=" + reportId + ", incident=" + incident + ", reportingOfficer=" + reportingOfficer
                + ", reportDate=" + reportDate + ", reportDetails=" + reportDetails + ", reportStatus=" + reportStatus + "]";
    }
}
