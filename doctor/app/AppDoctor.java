package app;

import java.sql.SQLException;
import java.util.Scanner;

import controllers.HospitalController;
import utils.Graphics;

public class AppDoctor {
  public static void runApplication() throws InterruptedException {

    Scanner sc = new Scanner(System.in);
    Graphics graphics = new Graphics();
    graphics.logoGraphics();

    HospitalController hospitalController = new HospitalController();

    System.out.print("Bem vindo ao portal de medicina, digite numeros para qual setor deseja seguir. ");
    System.out.print("\n1 - Gerenciamento de Pessoas. ");
    System.out.print("\n2 - Gerenciamento de Hospitais.");
    System.out.println("\n0 - Fechar programa.");

    System.out.print("\nEscolha: ");

    int choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
      case 1:
        System.out.println("Entrando em gerenciamento de pessoas, por favor aguarde!");
        Thread.sleep(200);
        break;
      case 2:
        System.out.println("\nEntrando em gerenciamento de hospitais, por favor aguarde!");
        Thread.sleep(200);
        try {
          hospitalController.gerenciarHospitais();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      default:
        System.out.println("Obrigado por usar o sistema.");
        break;
    }
    sc.close();
  }

  public static void backtrack() throws InterruptedException {

    Scanner sc = new Scanner(System.in);

    System.out.println("\nDeseja voltar para o menu inicial?");
    System.out.println("\n1 - Voltar");
    System.out.println("\n0 - Fechar aplicação");

    int choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
      case 1:
        runApplication();
        break;
      default:
        System.out.println("Obrigado por usar o sistema.");
        break;
    }
    sc.close();
  }
}
