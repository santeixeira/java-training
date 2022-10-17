package controllers.Pessoas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.AppDoctor;
import models.Pessoa;
import services.PessoaService;

public class MedicoController {
  PessoaService ps = new PessoaService();
  AppDoctor doc = new AppDoctor();
  List<Pessoa> pessoas = new ArrayList<Pessoa>();

  public void gerenciarCadastro() throws InterruptedException, SQLException {

    Scanner sc = new Scanner(System.in);

    System.out.println("1 - Mostrar todos os usuarios.");
    Thread.sleep(20);
    System.out.println("2 - Mostrar usario por ID");
    Thread.sleep(20);
    System.out.println("3 - Adicionar um usuario");
    Thread.sleep(20);
    System.out.println("4 - Alterar um usuario");
    Thread.sleep(20);
    System.out.println("5 - Deletar um usuario");
    Thread.sleep(20);
    System.out.println("0 - Voltar para menu");
    Thread.sleep(20);

    System.out.print("\nEscolha: ");
    byte choice = sc.nextByte();

    switch (choice) {
      case 1:
        System.out.println("Mostrando e listando todos as pessoas do sistema, aguarde!");
        pessoas = ps.getPessoa();
        pessoas.stream().forEach(p -> System.out.println(p));
        AppDoctor.backtrack();
        break;
      case 2:
        System.out.println("\nDigite o CPF do usuario: ");
        String cpf = sc.next();
        System.out.print("Mostrando o usuario de CPF: " + cpf + ", aguarde!");
        Thread.sleep(100);
        ps.getPessoaByCpf(cpf);
        AppDoctor.backtrack();
        break;
      case 3:
        Thread.sleep(100);
        ps.postPessoa();
        AppDoctor.backtrack();
        break;
      case 4:
        // System.out.println("\nDigite o id do hospital: ");
        // Long hospitalIdUpdate = sc.nextLong();
        // hs.updateHospital(hospitalIdUpdate);
        AppDoctor.backtrack();
        break;
      case 5:
        // System.out.println("\nDigite o id do hospital: ");
        // Long hospitalIdDelete = sc.nextLong();
        // hs.deleteHospital(hospitalIdDelete);
        AppDoctor.backtrack();
        break;
      default:
        System.out.println("Voltando para o menu inicial!");
        Thread.sleep(300);
        AppDoctor.runApplication();
        break;
    }
    sc.close();
  }
}
