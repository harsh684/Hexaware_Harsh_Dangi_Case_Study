package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class for obtaining a database connection using properties from a
 * configuration file.
 */
public class DbPropertyUtil {

  /** The database connection instance. */
  static Connection connection;

  /**
   * Gets a database connection using properties from the configuration file.
   *
   * @return The database connection.
   */
  public static Connection getMyDbConnection() {

    // Specify the path to the properties file
    String filename = "src/main/resources/db.properties";

    // Load properties from the file
    Properties props = new Properties();
    FileInputStream fis;

    try {
      fis = new FileInputStream(filename);
      props.load(fis);

      // Retrieve database connection properties from the loaded properties
      String url = props.getProperty("db.url");
      String un = props.getProperty("db.username");
      String pass = props.getProperty("db.password");

      // Establish a database connection using DriverManager
      connection = DriverManager.getConnection(url, un, pass);

    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return connection;
  }

  /**
   * Main method to test obtaining a database connection.
   *
   * @param args Command line arguments (not used in this case).
   */
  public static void main(String[] args) {
    System.out.println(getMyDbConnection());
  }
}
