package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.AppDoctor;
import controllers.Pessoas.CadastroController;
import models.Pessoa;
import services.PessoaService;

public class PessoasController {
  AppDoctor doc = new AppDoctor();
  CadastroController cc = new CadastroController();

  public void gerenciarPessoas() throws InterruptedException, SQLException {

    Scanner sc = new Scanner(System.in);

    System.out.println("1 - Gerenciar cadastros.");
    Thread.sleep(20);
    System.out.println("2 - Gerenciar Pacientes");
    Thread.sleep(20);
    System.out.println("3 - Gerenciar Medicos");
    Thread.sleep(20);
    System.out.println("0 - Voltar para menu");
    Thread.sleep(20);

    System.out.print("\nEscolha: ");
    byte choice = sc.nextByte();

    switch (choice) {
      case 1:
        cc.gerenciarCadastro();
        AppDoctor.backtrack();
        break;
      case 2:

        AppDoctor.backtrack();
        break;
      case 3:
        // ps.postPessoa();
        AppDoctor.backtrack();
        break;
      case 4:

        AppDoctor.backtrack();
        break;
      case 5:

        AppDoctor.backtrack();
        break;
      default:

        AppDoctor.runApplication();
        break;
    }
    sc.close();
  }
}
