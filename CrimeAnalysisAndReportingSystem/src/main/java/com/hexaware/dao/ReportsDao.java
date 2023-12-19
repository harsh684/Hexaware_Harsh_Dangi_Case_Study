package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.hexaware.controller.IncidentController;
import com.hexaware.controller.LawEnforcementAgencyController;
import com.hexaware.controller.OfficerController;
import com.hexaware.controller.ReportController;
import com.hexaware.controller.SuspectController;
import com.hexaware.controller.VictimController;
import com.hexaware.entity.Incidents;
import com.hexaware.entity.LawEnforcementAgencies;
import com.hexaware.entity.Officers;
import com.hexaware.entity.Reports;
import com.hexaware.entity.Suspects;
import com.hexaware.entity.Victims;
import com.hexaware.util.DbPropertyUtil;


/**
 * DAO (Data Access Object) class for Reports.
 * Manages database operations related to Reports.
 */
public class ReportsDao {

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Reports report;

    /**
     * Retrieves and populates Reports data into an array.
     */
    public void putReportsToArray() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Reports");
            while (resultSet.next()) {
                report = new Reports();
                report.setReportId(resultSet.getInt(1));

                // Find the related incident from the incident list
                for (Incidents i : IncidentController.incidentList) {
                    if (i.getIncidentId() == resultSet.getInt(2)) {
                        report.setIncident(i);
                        break;
                    }
                }

                // Find the reporting officer from the officer list
                for (Officers s : OfficerController.officerList) {
                    if (s.getOfficerId() == resultSet.getInt(3)) {
                        report.setReportingOfficer(s);
                        break;
                    }
                }

                report.setReportDate(resultSet.getDate(4).toLocalDate());
                report.setReportDetails(resultSet.getString(5));
                report.setReportStatus(resultSet.getString(6));

                ReportController.reportsList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new Report to the database.
     *
     * @param object The Report object to be added.
     * @return True if the report is added successfully, false otherwise.
     */
    public boolean addReport(Reports object) {
        boolean isInserted = false;
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into Reports values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, object.getReportId());
            preparedStatement.setInt(2, object.getIncident().getIncidentId());
            preparedStatement.setInt(3, object.getReportingOfficer().getOfficerId());
            Date date = Date.valueOf(object.getReportDate());
            preparedStatement.setDate(4, date);
            preparedStatement.setString(5, object.getReportDetails());
            preparedStatement.setString(6, object.getReportStatus());

            int noOfRows = preparedStatement.executeUpdate();
            isInserted = noOfRows != 0;
            System.out.println(noOfRows + " inserted successfully !!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInserted;
    }
}

