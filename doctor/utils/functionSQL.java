package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import config.DbConnection;

public class functionSQL {
  DbConnection dbConnection = new DbConnection();
  Connection connection = dbConnection.Connect();

  public void getIndexFromTable(String column, String table) {
    try {
      PreparedStatement statement = connection.prepareStatement("SELECT COUNT( ? ) from ?",
          Statement.RETURN_GENERATED_KEYS);
      statement.setString(1, column);
      statement.setString(2, table);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
