package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.controller.CaseController;
import com.hexaware.controller.IncidentController;
import com.hexaware.entity.Cases;
import com.hexaware.entity.Incidents;
import com.hexaware.util.DbPropertyUtil;

/**
 * DAO (Data Access Object) class for Cases.
 * Manages database operations related to Cases.
 */
public class CasesDao {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Cases c;

    /**
     * Retrieves and populates Cases data into an array.
     */
    public void putCaseToArray() {
        try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Cases");
            while (resultSet.next()) {
                c = new Cases();
                c.setCaseId(resultSet.getInt(1));

                // Find the related incident from the incident list
                for (Incidents i : IncidentController.incidentList) {
                    if (i.getIncidentId() == resultSet.getInt(2)) {
                        c.setRelatedIncidents(i);
                        break;
                    }
                }

                c.setCaseDescription(resultSet.getString(3));
                CaseController.caseList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new Case to the database.
     *
     * @param cases The Cases object to be added.
     */
    public boolean addCase(Cases cases) {
        boolean isCreated=false;
    	try {
            connection = DbPropertyUtil.getMyDbConnection();
            preparedStatement = connection.prepareStatement("insert into Cases values(?,?,?)");
            preparedStatement.setInt(1, cases.getCaseId());
            preparedStatement.setInt(2, cases.getRelatedIncidents().getIncidentId());
            preparedStatement.setString(3, cases.getCaseDescription());
            int noOfRows = preparedStatement.executeUpdate();
            if(noOfRows!=0)isCreated=true;
            System.out.println(noOfRows + " Case Added!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }
    
    public boolean updateCaseDetails(Cases cases) {
    	boolean isUpdated=false;
    	try {
    		connection = DbPropertyUtil.getMyDbConnection();
    		preparedStatement=connection.prepareStatement("update Cases set incidentId="
    		+cases.getRelatedIncidents().getIncidentId()+", caseDescription='"+cases.getCaseDescription()
    		+"' where caseId="+cases.getCaseId());
    	
    		int noOfRows=preparedStatement.executeUpdate();
    		if(noOfRows!=0)isUpdated=true;
    		System.out.println(noOfRows+" Case Updated");
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return isUpdated;
    }
    
    public List<Cases> getAllCases(){
    	List<Cases> result=new ArrayList<Cases>();
    	try {
            connection = DbPropertyUtil.getMyDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Cases");
            while (resultSet.next()) {
                c = new Cases();
                c.setCaseId(resultSet.getInt(1));

                // Find the related incident from the incident list
                for (Incidents i : IncidentController.incidentList) {
                    if (i.getIncidentId() == resultSet.getInt(2)) {
                        c.setRelatedIncidents(i);
                        break;
                    }
                }

                c.setCaseDescription(resultSet.getString(3));
                result.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return result;
    }
}
