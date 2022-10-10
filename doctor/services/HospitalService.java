package services;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import models.Hospital;

public class HospitalService {

    Scanner sc = new Scanner(System.in);
    List<Hospital> hospital = new ArrayList<>();

    protected void getHospital() {
        for (Hospital h : hospital) {
            System.out.println("{ nome: " + h.getNome() + ",\n endereco: " + h.getEndereco() + "}");
        }
    }

    protected void postHospital() {
        System.out.println("\nDigite um nome para o hospital: ");
        String nomeHospital = sc.next();
        System.out.println("\nDigite o endereço para o hospital: ");
        String enderecoHospital = sc.next();
        Hospital h = new Hospital(nomeHospital, enderecoHospital);
        hospital.add(h);
        System.out.println("Hospital Adicionado!");
    }

    protected void getHospitalById(Long id) {
        for (Hospital h : hospital) {
            System.out.println("{ nome: " + h.getNome() + ",\n endereco: " + h.getEndereco() + "}");
        }
    }

    protected void updateHospital() {

    }

    protected void deleteHospital() {

    }
}
