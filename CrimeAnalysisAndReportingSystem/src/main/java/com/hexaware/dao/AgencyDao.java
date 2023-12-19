package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.controller.LawEnforcementAgencyController;
import com.hexaware.controller.SuspectController;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.entity.Suspects;
import com.hexaware.exception.InvalidDataException;
import com.hexaware.util.DbPropertyUtil;

/**
 * DAO (Data Access Object) class for Law Enforcement Agencies.
 * Manages database operations related to Law Enforcement Agencies.
 */
public class AgencyDao {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    LawEnforcementAgencies agency;

    /**
     * Retrieves and populates Law Enforcement Agencies data into an array.
     */
    public void putSuspectsToArray() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from LawEnforcementAgencies");
            while (resultSet.next()) {
                agency = new LawEnforcementAgencies();
                agency.setAgencyId(resultSet.getInt(1));
                agency.setAgencyName(resultSet.getString(2));
                agency.setJurisdiction(resultSet.getString(3));
                agency.setContactInfo(resultSet.getString(4));

                // Add the retrieved agency to the list in the controller
                LawEnforcementAgencyController.agencyList.add(agency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds the Law Enforcement Agencies data into the database.
     */
	public void addAgency(LawEnforcementAgencies agency) {
		try {
			connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into LawEnforcementAgencies values(?,?,?,?)");
            preparedStatement.setInt(1, agency.getAgencyId());
            preparedStatement.setString(2, agency.getAgencyName());
            preparedStatement.setString(3, agency.getJurisdiction());
            preparedStatement.setString(4, agency.getContactInfo());
         
            int noOfRows = preparedStatement.executeUpdate();
            System.out.println(noOfRows + " Agency inserted successfully !!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}

