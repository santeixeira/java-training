package controller;
import services.FuncionarioService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import models.Funcionario;

public class FuncionarioController {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void post() throws ParseException, IOException {
        FuncionarioService.adicionarFuncionario();
    }

    public static void get(int choice) {
        switch (choice) {
            case 1:
                break;
        }
    }
}
