package models;

import java.util.Date;

import models.enums.Sexo;

public class Pessoa {
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private String cpf;
    private Sexo sexo;

    public Pessoa() {
    }

    public Pessoa(String nome, String endereco, Date dataNascimento, String cpf, Sexo sexo) {
        super();
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void pessoaAnda() {
        System.out.println(this.nome + " está andando.");
    }
}