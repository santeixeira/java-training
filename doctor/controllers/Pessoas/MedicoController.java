package controllers.Pessoas;

import java.sql.SQLException;
import java.util.Scanner;

import app.AppDoctor;
import services.MedicoService;
import utils.functionSQL;

public class MedicoController {
  MedicoService medico = new MedicoService();
  AppDoctor doc = new AppDoctor();

  public void gerenciarCadastro() throws InterruptedException, SQLException {

    Scanner sc = new Scanner(System.in);
    functionSQL fSql = new functionSQL();

    fSql.crudTexts("medico");

    System.out.print("\nEscolha: ");
    byte choice = sc.nextByte();

    switch (choice) {
      case 1:
        System.out.println("Mostrando e listando todos os medicos do sistema, aguarde!");
        medico.getMedico();
        AppDoctor.backtrack();
        break;
      case 2:
        System.out.println("\nDigite o CRM do medico: ");
        String crm = sc.next();
        System.out.print("Mostrando o usuario de CPF: " + crm + ", aguarde!");
        Thread.sleep(100);
        medico.getMedicoByCrm(crm);
        AppDoctor.backtrack();
        break;
      case 3:
        System.out.println("\nDigite o CPF do medico: ");
        String cpf = sc.next();
        Thread.sleep(100);
        medico.postMedico(cpf);
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
