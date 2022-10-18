package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.DbConnection;
import models.Medico;

public class MedicoService extends Medico {

    Scanner sc = new Scanner(System.in);
    DbConnection db = new DbConnection();
    Connection connection = db.Connect();

    List<Medico> medicoList = new ArrayList<>();

    public List<Medico> getMedico() {
        String query = "SELECT M.CRM, m.ESPECIALIZACAO, P.NOME_PESSOA FROM MEDICO M, PESSOA P WHERE P.PESSOA_ID = M.PESSOA_ID";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Medico medico = new Medico(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
                medicoList.add(medico);
            }
            for (Medico m : medicoList) {
                System.out.println(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicoList;
    }

    public void postMedico(String cpf) {
        System.out.println("Digite CRM: ");
        this.setCrm(sc.nextLine());
        System.out.println("Digite Salario: ");
        this.setSalario(Double.parseDouble(sc.nextLine()));
        System.out.println("Digite Especializacao: ");
        this.setEspecializacao(sc.nextLine());

        String query = "INSERT INTO MEDICO (CRM, SALARIO, ESPECIALIZACAO, PESSOA_ID) VALUES (?, ?, ?, (SELECT P.PESSOA_ID FROM PESSOA P WHERE CPF = '"
                + cpf + "'))";
        System.out.println(query);
        try (PreparedStatement ps = connection.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, this.getCrm());
            ps.setDouble(2, this.getSalario());
            ps.setString(3, this.getEspecializacao());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                System.out.println("Medico ID: " + id + " cadastrado no sistema.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medico> getMedicoByCrm(String crm) {
        return null;
    }

    public Medico updateMedico() {
        return null;
    }

    public Medico deleteMedico() {
        return null;
    }
}
