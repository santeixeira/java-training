package services;

import java.util.Scanner;

import config.DbConnection;
import models.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HospitalService extends Hospital {

    Scanner sc = new Scanner(System.in);
    DbConnection db = new DbConnection();
    Connection connection = db.Connect();

    protected void getHospital() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM HOSPITAL");
        ResultSet rst = ps.getResultSet();
        while (rst.next()) {
            String query = rst.getString(1);
            System.out.println("bla bla: " + query);
        }
    }

    public void postHospital() {
        try {
            System.out.println("Digite o nome do hospital: ");
            String nome = sc.nextLine();
            System.out.println("Digite o endereco do hospital: ");
            String endereco = sc.nextLine();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO HOSPITAL (NOME, ENDERECO) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, nome);
            ps.setString(2, endereco);

            ps.execute();

            System.out.println(ps);
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                System.out.println("O hospital com ID " + id + " foi criado com sucesso!");
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("ERROR: Nao foi possivel criar um estado.");
            e.printStackTrace();
        }

    }

    // protected void getHospitalById(Long id) {
    // for (Hospital h : hospital) {
    // System.out.println("{ nome: " + h.getNome() + ",\n endereco: " +
    // h.getEndereco() + "}");
    // }
    // }

    protected void updateHospital() {

    }

    protected void deleteHospital() {

    }
}
