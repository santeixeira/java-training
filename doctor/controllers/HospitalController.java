package controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import app.AppDoctor;
import models.Hospital;
import services.HospitalService;

public class HospitalController extends HospitalService {

    HospitalService hs = new HospitalService();
    AppDoctor doc = new AppDoctor();

    public void gerenciarHospitais() throws InterruptedException, SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Mostrar todos os hospitais.");
        Thread.sleep(20);
        System.out.println("2 - Mostrar hospital por ID");
        Thread.sleep(20);
        System.out.println("3 - Adicionar um hospital");
        Thread.sleep(20);
        System.out.println("4 - Alterar um hopistal");
        Thread.sleep(20);
        System.out.println("5 - Deletar um hospital");
        Thread.sleep(20);
        System.out.println("0 - Voltar para menu");
        Thread.sleep(20);

        System.out.print("\nEscolha: ");
        byte choice = sc.nextByte();

        switch (choice) {
            case 1:
                System.out.println("Mostrando e listando todos os hospitais do sistema, aguarde!");
                Thread.sleep(200);
                List<Hospital> hospitais = hs.getHospital();
                hospitais.stream().forEach(h -> System.out.println(h));
                AppDoctor.backtrack();
                break;
            case 2:
                System.out.println("\nDigite o id do hospital: ");
                Long hospitalId = sc.nextLong();
                System.out.println("Mostrando e listando todos os hospitais do sistema, aguarde!");
                Thread.sleep(100);
                hs.getHospitalById(hospitalId);
                AppDoctor.backtrack();
                break;
            case 3:
                Thread.sleep(100);
                hs.postHospital();
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
