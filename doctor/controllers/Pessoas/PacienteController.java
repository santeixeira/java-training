package controllers.Pessoas;

import java.util.Scanner;

import app.AppDoctor;
import services.PacienteService;
import utils.functionSQL;

public class PacienteController {
  public void gerenciarCadastro() throws InterruptedException {

    Scanner sc = new Scanner(System.in);
    functionSQL fSql = new functionSQL();
    PacienteService pService = new PacienteService();

    fSql.crudTexts("paciente");

    System.out.print("\nEscolha: ");
    byte choice = sc.nextByte();

    switch (choice) {
      case 1:
        System.out.println("Mostrando e listando todos os pacientes do sistema, aguarde!");
        pService.getPacientes();
        AppDoctor.backtrack();
        break;
      case 2:
        String cpf = fSql.getByCpf("paciente");
        pService.getPacientesByCPF(cpf);
        AppDoctor.backtrack();
        break;
      case 3:
        String cpfPost = fSql.getByCpf("paciente");
        pService.postPaciente(cpfPost);
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
