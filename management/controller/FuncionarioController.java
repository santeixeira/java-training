package controller;

import services.FuncionarioService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import app.Main;

public class FuncionarioController {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void run() throws ParseException, IOException {
        System.out.print("Digite o numero do que deseja fazer: ");
        System.out.println("\n1 - Adicionar um novo funcionário");
        System.out.println("\n2 - Gerenciar funcionários");
        System.out.println("\n0 - Fechar o Sistema");
        int choice = Integer.parseInt(rd.readLine());
        switch (choice) {
            case 1:
                System.out.println("Adicionando um novo funcionário:");
                post();
                break;
            case 2:
                System.out.println("Selecione uma das opções: ");
                System.out.println("\n1 - Visualizar um funcionário");
                System.out.println("\n2 - Visualizar todos os funcionários");
                choice = Integer.parseInt(rd.readLine());
                FuncionarioController.get(choice);

                break;
            case 0:
                System.out.println("Obrigado por utilizar nosso sistema.");
                break;
        }
    }

    public static void post() throws ParseException, IOException {
        FuncionarioService.adicionarFuncionario();
    }

    public static void get(int choice) throws ParseException, IOException {

        switch (choice) {
            case 1:
                break;
            case 0:
                Main.main(null);
                break;
        }
    }
}
