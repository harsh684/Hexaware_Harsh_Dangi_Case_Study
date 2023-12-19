package com.test.hexaware;

import static org.junit.Assert.assertTrue;

import com.hexaware.controller.IncidentController;
import com.hexaware.controller.OfficerController;
import com.hexaware.dao.ReportsDao;
import com.hexaware.entity.Reports;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * JUnit test class for testing the functionality of ReportsDao.
 */
public class ReportsDaoTest {
  private static ReportsDao reportsDao;  private static IncidentController incidentController;  private static OfficerController officerController;
  /**   * Set up resources before the test class runs.   */  @BeforeClass  public static void setUpClass() {     reportsDao = new ReportsDao();    incidentController = new IncidentController();    incidentController.putIncidentsToArray();    officerController = new OfficerController();    officerController.putOfficersToArray();  }
  /**   * Test case for adding a report to the database.   */  @Test   public void addReportTest() {    Reports report = new Reports(2, incidentController.incidentList.get(0),        officerController.officerList.get(0), LocalDate.parse("2023-01-01"),        "Test Report details", "Test");     assertTrue(reportsDao.addReport(report));  }
  /**   * Clean up resources after the test class has run.   */  @AfterClass  public static void tearDown() {    reportsDao = null;    incidentController = null;    officerController = null;  }
}

