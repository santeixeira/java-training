package models;

import java.util.Date;

import models.enums.Sexo;

public class Pessoa {
    private Long pessoaId;
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private String cpf;
    private Sexo sexo;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        super();
        this.nome = nome;
    }

    public Pessoa(Long pessoaId, String nome, String endereco, Date dataNascimento, String cpf, Sexo sexo) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
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

    public void setData(Date dataNascimento) {
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

    @Override
    public String toString() {
        return String.format("\nID: %d \t Nome: %s \t Endereço: %s \t dataNascimento: %s \t CPF: %s \t Sexo: %s",
                this.pessoaId,
                this.getNome(),
                this.getEndereco(),
                this.getDataNascimento(),
                this.getCpf(),
                this.getSexo());
    }
}