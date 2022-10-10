package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Funcionario;

public class FuncionarioService extends Funcionario {

    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
    static List<Funcionario> listaFuncionario = new ArrayList<>();

    public FuncionarioService(String nome, String setor, Double salario, Date dataAdmissao) {
        super(nome, setor, salario, dataAdmissao);
    }

    public static void adicionarFuncionario() throws ParseException, IOException {

        try {
            System.out.print("Informe o nome do Funcionario: ");
            String nome = rd.readLine();

            System.out.print("Data de Admissao do funcionario: ");
            Date dataAdmissao = datef.parse(rd.readLine());

            System.out.print("Delegue uma função para o funcionario: ");
            String setor = rd.readLine();

            System.out.print("Informe o salário do funcionario: ");
            Double salario = Double.parseDouble(rd.readLine());

            Funcionario funcionario = new Funcionario(nome, setor, salario, dataAdmissao);

            listaFuncionario.add(funcionario);
            funcionario.getFuncionario();

        } catch (ParseException e) {
            System.out.println("Data informada é inválida.");
        }
    }

}
