package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query = "SELECT * FROM PACIENTES";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3));
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
}
