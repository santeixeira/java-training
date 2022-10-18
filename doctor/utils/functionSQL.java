package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import config.DbConnection;

public class functionSQL {
  Scanner sc = new Scanner(System.in);
  DbConnection dbConnection = new DbConnection();
  Connection connection = dbConnection.Connect();

  public String cpf;

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

  public void crudTexts(String table) {
    try {
      System.out.println("1 - Mostrar todos os " + table + "s");
      Thread.sleep(20);
      System.out.println("2 - Mostrar " + table + " por ID");
      Thread.sleep(20);
      System.out.println("3 - Adicionar um " + table);
      Thread.sleep(20);
      System.out.println("4 - Alterar um " + table);
      Thread.sleep(20);
      System.out.println("5 - Deletar um " + table);
      Thread.sleep(20);
      System.out.println("0 - Voltar para menu");
      Thread.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public String getByCpf(String table) throws InterruptedException {
    System.out.println("\nDigite o CPF do " + table + ":");
    String cpf = sc.next();
    Thread.sleep(100);
    return cpf;

  }

}