package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.controller.VictimController;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.Victims;
import com.hexaware.util.DbPropertyUtil;


/**
 * DAO (Data Access Object) class for Victims.
 * Manages database operations related to Victims.
 */
public class VictimsDao {

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Victims v;

    /**
     * Retrieves and populates Victims data into an array.
     */
    public void putVictimsToArray() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Victims");
            while (resultSet.next()) {
                v = new Victims();
                v.setVictimId(resultSet.getInt(1));
                v.setFirstName(resultSet.getString(2));
                v.setLastName(resultSet.getString(3));
                v.setDob(resultSet.getDate(4).toLocalDate());
                v.setGender(resultSet.getString(5));
                v.setAddress(resultSet.getString(6));
                v.setPhone(resultSet.getString(7));

                VictimController.victimList.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new victim to the database.
     *
     * @param victim The victim object to be added.
     */
    public void addVictim(Victims victim) {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into Victims values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, victim.getVictimId());
            preparedStatement.setString(2, victim.getFirstName());
            preparedStatement.setString(3, victim.getLastName());
            preparedStatement.setDate(4, Date.valueOf(victim.getDob()));
            preparedStatement.setString(5, victim.getGender());
            preparedStatement.setString(6, victim.getAddress());
            preparedStatement.setString(7, victim.getPhone());

            int noofrows = preparedStatement.executeUpdate();
            System.out.println(noofrows + " Victim Details Added!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
