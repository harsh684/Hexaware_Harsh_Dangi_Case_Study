package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.controller.CaseController;
import com.hexaware.controller.IncidentController;
import com.hexaware.controller.LawEnforcementAgencyController;
import com.hexaware.controller.OfficerController;
import com.hexaware.entity.Cases;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.entity.Officers;
import com.hexaware.util.DbPropertyUtil;


/**
 * DAO (Data Access Object) class for Officers.
 * Manages database operations related to Officers.
 */
public class OfficersDao {

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Officers officer;

    /**
     * Retrieves and populates Officers data into an array.
     */
    public void putOfficersToArray() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Officers");
            while (resultSet.next()) {
                officer = new Officers();
                officer.setOfficerId(resultSet.getInt(1));
                officer.setFirstName(resultSet.getString(2));
                officer.setLastName(resultSet.getString(3));
                officer.setBadgeNo(resultSet.getString(4));
                officer.setRank(resultSet.getString(5));
                officer.setContactInfo(resultSet.getString(6));

                // Find the related agency from the agency list
                for (LawEnforcementAgencies l : LawEnforcementAgencyController.agencyList) {
                    if (l.getAgencyId() == resultSet.getInt(7)) {
                        officer.setAgency(l);
                        break;
                    }
                }

                OfficerController.officerList.add(officer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new Officer to the database.
     *
     * @param officer The Officer object to be added.
     */
    public void addOfficer(Officers officer) {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into Officers values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, officer.getOfficerId());
            preparedStatement.setString(2, officer.getFirstName());
            preparedStatement.setString(3, officer.getLastName());
            preparedStatement.setString(4, officer.getBadgeNo());
            preparedStatement.setString(5, officer.getRank());
            preparedStatement.setString(6, officer.getContactInfo());
            preparedStatement.setInt(7, officer.getAgency().getAgencyId());

            int noOfRows = preparedStatement.executeUpdate();
            System.out.println(noOfRows + " Officer inserted successfully !!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
