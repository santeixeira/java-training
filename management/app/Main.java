package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import controller.FuncionarioController;

public class Main {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws ParseException, NumberFormatException, IOException {

        System.out.print("Bem vindo ao controle da empresa POO de funcionarios");

        System.out.print("Digite o numero do que deseja fazer: ");

        System.out.println("\n1 - Adicionar um novo funcionário");
        System.out.println("\n2 - Gerenciar funcionários");
        System.out.println("\n0 - Fechar o Sistema");

        int choice = Integer.parseInt(rd.readLine());
        switch (choice) {
            case 1:
                System.out.println("Adicionando um novo funcionário:");
                FuncionarioController.post();
                break;
            case 2:
                System.out.println("Selecione uma das opções: ");
                System.out.println("\n1 - Visualizar um funcionário");
                System.out.println("\n2 - Visualizar todos os funcionários");
                choice = Integer.parseInt(rd.readLine());;
                break;
            case 0:
                System.out.println("Obrigado por utilizar nosso sistema.");
                break;
        }

    }
}
