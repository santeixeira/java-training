package services;

import java.util.ArrayList;
import java.util.List;
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
    List<Hospital> hospitais = new ArrayList<Hospital>();

    public HospitalService() {
    }

    public HospitalService(Long hospitalId, String nome, String endereco) {
        super(hospitalId, nome, endereco);
    }

    public List<Hospital> getHospital() {
        String query = "SELECT * FROM HOSPITAL";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            ResultSet rst = ps.getResultSet();
            while (rst.next()) {
                Hospital hospital = new Hospital(rst.getLong(1), rst.getString(2), rst.getString(3));
                hospitais.add(hospital);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitais;

    }

    public void postHospital() {
        System.out.println("Digite o nome do hospital: ");
        this.nome = sc.nextLine();
        System.out.println("Digite o endereco do hospital: ");
        this.endereco = sc.nextLine();
        String query = "INSERT INTO HOSPITAL (NOME, ENDERECO) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, this.getNome());
            ps.setString(2, this.getEndereco());

            ps.execute();

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

    public void getHospitalById(Long hospitalId) {
        String query = "SELECT * FROM HOSPITAL WHERE HOSPITAL_ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, hospitalId);
            ps.execute();
            ResultSet rst = ps.getResultSet();
            while (rst.next()) {
                Hospital hospital = new Hospital(rst.getLong(1), rst.getString(2), rst.getString(3));
                System.out.println(hospital);
            }
            rst.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHospital(Long hospitalId) {
        String query = "UPDATE hospital SET nome = ? WHERE hospital_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("Digite o nome do hospital: ");
            this.nome = sc.nextLine();

            ps.setString(1, this.getNome());
            ps.setLong(2, hospitalId);
            ps.execute();

            System.out.println("O nome do Hospital " + hospitalId + " foi alterado para " + this.getNome());

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHospital(Long hospitalId) {
        String query = "DELETE FROM HOSPITAL WHERE HOSPITAL_ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, hospitalId);
            ps.execute();

            System.out.println("Hospital " + hospitalId + " foi deletado com sucesso!");
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
