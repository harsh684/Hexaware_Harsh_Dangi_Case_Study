package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.controller.SuspectController;
import com.hexaware.controller.VictimController;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Suspects;
import com.hexaware.entity.Victims;
import com.hexaware.util.DbPropertyUtil;


/**
 * DAO (Data Access Object) class for Suspects.
 * Manages database operations related to Suspects.
 */
public class SuspectsDao {

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Suspects s;

    /**
     * Retrieves and populates Suspects data into an array.
     */
    public void putSuspectsToArray() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Suspects");
            while (resultSet.next()) {
                s = new Suspects();
                s.setSuspectId(resultSet.getInt(1));
                s.setFirstName(resultSet.getString(2));
                s.setLastName(resultSet.getString(3));
                s.setDob(resultSet.getDate(4).toLocalDate());
                s.setGender(resultSet.getString(5));
                s.setContactInfo(resultSet.getString(6));

                SuspectController.suspectsList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**Adds suspect details to the database.
     * 
     * @param suspect
     */
	public void addSuspects(Suspects suspect) {
		try {
            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into Suspects values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, suspect.getSuspectId());
            preparedStatement.setString(2, suspect.getFirstName());
            preparedStatement.setString(3, suspect.getLastName());
            preparedStatement.setDate(4, Date.valueOf(suspect.getDob()));
            preparedStatement.setString(5, suspect.getGender());
            preparedStatement.setString(6, suspect.getContactInfo());

            int noofrows = preparedStatement.executeUpdate();
            System.out.println(noofrows + " Suspect Details Added!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}

