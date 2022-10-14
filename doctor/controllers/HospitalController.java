package controllers;

import java.util.Scanner;

import services.HospitalService;

public class HospitalController extends HospitalService {

    HospitalService hs = new HospitalService();

    public void gerenciarHospitais() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Mostrar todos os hospitais.");
        System.out.println("2 - Mostrar hospital por ID");
        System.out.println("3 - Adicionar um hospital");
        System.out.println("4 - Alterar um hopistal");
        System.out.println("5 - Deletar um hospital");

        byte choice = sc.nextByte();

        switch (choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                Thread.sleep(100);
                hs.postHospital();
                break;
            case 4:

                break;
            case 5:

                break;
            default:
                break;
        }
        sc.close();
    }
}
