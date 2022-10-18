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
import models.Paciente;

public class PacienteService extends Paciente {
    List<Paciente> pacientes = new ArrayList<Paciente>();
    Scanner sc = new Scanner(System.in);
    DbConnection db = new DbConnection();
    Connection connection = db.Connect();

    public List<Paciente> getPacientes() {
        String query = "SELECT * FROM PACIENTE";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getLong(1),
                        rs.getString(3),
                        rs.getString(4));
                pacientes.add(paciente);
            }
            for (Paciente p : pacientes) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public void postPaciente(String cpf) {

        System.out.println("Informe a doenca do paciente: ");
        this.setDoenca(sc.nextLine());
        System.out.println("Informe o medicamento do paciente: ");
        this.setMedicacao(sc.nextLine());

        String query = "INSERT INTO PACIENTE (PESSOA_ID, DOENCA, MEDICACAO) VALUES ((SELECT P.PESSOA_ID FROM PESSOA P WHERE CPF = '"
                + cpf + "'), ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, this.getDoenca());
            ps.setString(2, this.getMedicacao());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                System.out.println("Paciente ID: " + id + " adicionado ao sistema.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> getPacientesByCPF(String cpf) {
        return null;
    }

    // public void updatePaciente(String cpf) {
    //     String query = "SELECT * FROM PACIENTE";
    //     try (PreparedStatement ps = connection.prepareStatement(query)) {
    //         ps.execute();
    //         ResultSet rs = ps.getResultSet();
    //         while (rs.next()) {
    //             Paciente paciente = new Paciente(rs.getLong(1),
    //                     rs.getString(3),
    //                     rs.getString(4));
    //             pacientes.add(paciente);
    //         }
    //         for (Paciente p : pacientes) {
    //             System.out.println(p);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return pacientes;
    // }

    public void deletePaciente(String cpf) {
    }
}
