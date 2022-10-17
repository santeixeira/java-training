package services;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.DbConnection;
import models.Pessoa;
import models.enums.Sexo;
import utils.FormatDate;

public class PessoaService extends Pessoa {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    FormatDate formatDate = new FormatDate();
    DbConnection db = new DbConnection();
    Connection connection = db.Connect();

    List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public PessoaService() {
    }

    public PessoaService(Long pessoaId, String nome, String endereco, Date dataNascimento, String cpf, Sexo sexo) {
        super(pessoaId, nome, endereco, dataNascimento, cpf, sexo);
    }

    public List<Pessoa> getPessoa() {
        String query = "SELECT * FROM PESSOA";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            ResultSet rst = ps.getResultSet();
            while (rst.next()) {
                java.util.Date fd = formatDate.sqlToUtil(rst.getDate(4));
                Pessoa pessoa = new Pessoa(rst.getLong(1), rst.getString(2), rst.getString(3), fd, rst.getString(5),
                        Sexo.FEMININO);
                pessoas.add(pessoa);
                for (Pessoa p : pessoas) {
                    System.out.println(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;

    }

    public void postPessoa() {

        try {
            System.out.println("Digite o nome do hospital: ");
            this.setNome(sc.nextLine());
            System.out.println("Digite o endereco do hospital: ");
            this.setEndereco(sc.nextLine());
            System.out.println("Digite o endereco do hospital: ");
            this.setData(format.parse(sc.nextLine()));
            System.out.println("Digite o endereco do hospital: ");
            this.setCpf(sc.nextLine());
            this.setSexo(Sexo.MASCULINO);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO PESSOA (NOME_PESSOA, ENDERECO, DATA_NASCIMENTO, CPF, SEXO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);) {

            Date dateSql = new java.sql.Date(this.getDataNascimento().getTime());

            ps.setString(1, this.getNome());
            ps.setString(2, this.getEndereco());
            ps.setDate(3, dateSql);
            ps.setString(4, this.getCpf());
            ps.setString(5, "M");

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                System.out.println("Pessoa ID: " + id + " cadastrado no sistema.");
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pessoa getPessoaByCpf(String cpf) {
        String query = "SELECT * FROM PESSOA WHERE CPF = " + cpf;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                java.util.Date fd = formatDate.sqlToUtil(rs.getDate(4));
                Pessoa pessoa = new Pessoa(rs.getLong(1), rs.getString(2), rs.getString(3), fd, rs.getString(5),
                        Sexo.FEMININO);
                pessoas.add(pessoa);
                for (Pessoa p : pessoas) {
                    System.out.println(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Pessoa updatePessoa() {
        return null;
    }

    public static Pessoa deletePessoa() {
        return null;
    }
}
