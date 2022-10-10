import java.util.Scanner;

import controllers.HospitalController;

public class Doctor {
    public static void main(String[] args) throws InterruptedException {

        HospitalController hospitalController = new HospitalController();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao portal de medicina, digite numeros para qual setor deseja seguir. ");
        System.out.println("\n1 - Gerenciamento de Pessoas. ");
        System.out.println("\n2 - Gerenciamento de Hospitais.");

        byte choice = sc.nextByte();
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
