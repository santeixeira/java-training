package models;

import java.util.Date;

import models.enums.Doenca;
import models.enums.Sexo;

public class Paciente extends Pessoa {
    protected Doenca doenca;
    protected String medicacao;

    public Paciente () {}

    public Paciente(String nome, String endereco, Date dataNascimento, String cpf, Sexo sexo, Doenca doenca,
            String medicacao) {
        super(nome, endereco, dataNascimento, cpf, sexo);
        this.doenca = doenca;
        this.medicacao = medicacao;
    }

    public String getMedicacao() {
        return medicacao;
    }
    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }
}
