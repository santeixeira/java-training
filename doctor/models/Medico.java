package models;

import java.util.Date;

import models.enums.Especializacao;
import models.enums.Sexo;

public class Medico extends Pessoa {
    private String crm;
    private Double salario;
    private Especializacao especializaco;

    public Medico() {
    }

    public Medico(String nome, String endereco, Date dataNascimento, String cpf, Sexo sexo, String crm, Double salario,
            Especializacao especializaco) {
        super(nome, endereco, dataNascimento, cpf, sexo);
        this.crm = crm;
        this.salario = salario;
        this.especializaco = especializaco;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Especializacao getEspecializaco() {
        return especializaco;
    }

    public void setEspecializaco(Especializacao especializaco) {
        this.especializaco = especializaco;
    }

    public void darPlantao() {
        System.out.println(this.getNome() + " dá plantao.");
    }

}
