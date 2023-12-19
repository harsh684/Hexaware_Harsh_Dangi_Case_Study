package com.test.hexaware;

import static org.junit.Assert.assertTrue;

import com.hexaware.controller.IncidentController;
import com.hexaware.dao.CasesDao;
import com.hexaware.entity.Cases;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * JUnit test class for testing the functionality of CasesDao.
 */
public class CasesDaoTest {

  private static CasesDao casesDao;
  private static IncidentController incidentController;

  /**
   * Set up resources before the test class runs.
   */
  @BeforeClass
  public static void setUpClass() { 
    casesDao = new CasesDao();
    incidentController = new IncidentController();
    incidentController.putIncidentsToArray();
  }

  /**
   * Test case for adding a case to the database.
   */
  @Test 
  public void addCaseTest() {
    Cases testCase = new Cases(1, "Test Case Description", IncidentController.incidentList.get(0));
    assertTrue(casesDao.addCase(testCase));
  }

  /**
   * Test case for updating case details in the database.
   */
  @Test
  public void updateCaseDetailsTest() {
    Cases testCase = new Cases();
    testCase.setCaseId(2);
    testCase.setCaseDescription("Updated Case Description");
    testCase.setRelatedIncidents(IncidentController.incidentList.get(0));

    assertTrue(casesDao.updateCaseDetails(testCase));
  }

  /**
   * Clean up resources after the test class has run.
   */
  @AfterClass
  public static void tearDown() {
    casesDao = null;
    incidentController = null;
  }
}
