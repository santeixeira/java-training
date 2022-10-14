import java.util.Scanner;

import config.DbConnection;
import controllers.HospitalController;
import utils.Graphics;

public class Doctor {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Graphics graphics = new Graphics();
        graphics.logoGraphics();

        HospitalController hospitalController = new HospitalController();

        System.out.print("Bem vindo ao portal de medicina, digite numeros para qual setor deseja seguir. ");
        System.out.print("\n1 - Gerenciamento de Pessoas. ");
        System.out.print("\n2 - Gerenciamento de Hospitais.");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Entrando em gerenciamento de pessoas, por favor aguarde!");
                Thread.sleep(200);
                break;
            case 2:
                System.out.println("Entrando em gerenciamento de hospitais, por favor aguarde!");
                Thread.sleep(200);
                hospitalController.gerenciarHospitais();
                break;
            default:
                System.out.println("Obrigado por usar o sistema.");
                break;
        }
        sc.close();
    }
}
