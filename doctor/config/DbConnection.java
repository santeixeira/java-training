package config;

import java.sql.*;

import javax.sql.DataSource;

public class DbConnection {

  private String url = "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_89732026fc9d848?serverTimezone=UTC";
  private String user = "b71e955e833746"; 
  private String password = "999cf753";
  
  // private String url = "jdbc:mysql://localhost:3306/API_HOSPITAL?serverTimezone=UTC";
  // private String user = "root";
  // private String password = "16345578tT@"; 
  public DataSource dataSource;

  public Connection Connect() {

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Error: Unable to load JDBC Driver");
      e.printStackTrace();
      return null;
    }

    try {

      return DriverManager.getConnection(this.url, this.user, this.password);
    } catch (SQLException e) {
      System.out.println("Error: Unable to establish a connection with the database!");
      e.printStackTrace();
      return null;
    }

  }
}
