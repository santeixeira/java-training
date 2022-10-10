package controller;
import java.util.Date;

import models.Funcionario;

import java.text.SimpleDateFormat;

public class Relogio extends Funcionario {
    public Date tempo;


    public Relogio(String nome, String setor, Double salario, Date dataAdmissao2, Date tempo) {
        super(nome, setor, salario, dataAdmissao2);
        this.tempo = tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public Date getTempo() {
        return tempo;
    }

    public void inicializar() {
        SimpleDateFormat datef = new SimpleDateFormat("hh:mm:ss");
        Date now = new Date();
        System.out.println("Horário de início: " + datef.format(now));
    }
}
