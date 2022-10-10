package controllers;

import java.util.Scanner;

import services.HospitalService;

public class HospitalController extends HospitalService {
    Scanner sc = new Scanner(System.in);
    byte choice = sc.nextByte();

    public void gerenciarHospitais() {
        switch (choice) {
            case 1:
                System.out.println("1 - Mostrar todos os hospitais.");
                break;
            case 2:
                System.out.println("2 - Mostrar hospital por ID");
                break;
            case 3:
                System.out.println("3 - Adicionar um hospital");
                break;
            case 4:
                System.out.println("4 - Alterar um hopistal");
                break;
            case 5:
                System.out.println("5 - Deletar um hospital");
                break;
            default:
                break;
        }
        sc.close();
    }
}
