package com.hexaware.dao;

import com.hexaware.entity.Cases;

/**
 * Interface for the Cases DAO (Data Access Object).
 */
public interface CasesDaoInterface {

  /**
     * Retrieves and populates the cases data into an array.
     */
  public void putCaseToArray();

  /**
     * Adds a new case to the database.
     *
     * @param cases The case object to be added.
     */
  public void addCase(Cases cases);
}





