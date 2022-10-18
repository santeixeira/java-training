package controllers;

import java.sql.SQLException;
import java.util.Scanner;

import app.AppDoctor;
import controllers.Pessoas.CadastroController;
import controllers.Pessoas.MedicoController;
import controllers.Pessoas.PacienteController;

public class PessoasController {
  AppDoctor doc = new AppDoctor();
  CadastroController cc = new CadastroController();
  MedicoController m = new MedicoController();
  PacienteController p = new PacienteController();

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
        p.gerenciarCadastro();
        AppDoctor.backtrack();
        break;
      case 3:
        m.gerenciarCadastro();
        AppDoctor.backtrack();
        break;
      default:
        AppDoctor.runApplication();
        break;
    }
    sc.close();
  }
}
