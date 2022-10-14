package config;

import java.sql.*;

public class DbConnection {

  public Connection Connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Error: Unable to load JDBC Driver");
      e.printStackTrace();
      return null;
    }

    try {
      return DriverManager
          .getConnection("jdbc:mysql://localhost:3306/API_HOSPITAL?serverTimezone=UTC", "root", "16345578tT@");
    } catch (SQLException e) {
      System.out.println("Error: Unable to establish a connection with the database!");
      e.printStackTrace();
      return null;
    }

  }
}
