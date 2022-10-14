package models;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Funcionario {
    private static int id;
    private String nome;
    private Double salario;
    private String setor;
    private Date dataAdmissao;

    public Funcionario(String nome, String setor, Double salario, Date dataAdmissao2) {
        super();
        Funcionario.id = id++;
        this.nome = nome;
        this.salario = salario;
        this.setor = setor;
        this.dataAdmissao = dataAdmissao2;
    }

    public void getFuncionario() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("ID\t\tNome\t\tSetor\t\tDtAdmissao\t\tSalario");
        System.out.printf(Funcionario.id + "\t\t" + this.nome + "\t\t" + this.setor + "\t\t"
                + new SimpleDateFormat().format(this.dataAdmissao)
                + "\t\t" + this.salario);
        System.out.println("\n--------------------------------------------------------------------");
    }

    public void setSalario(Double salario) {
        if (salario <= 1100.00) {
            System.out.println("Não é possível adicionar um valor a baixo do salário mínimo.");
        } else {
            this.salario = salario;
        }
    }

    public void setDataAdmissao(Date dataAdmissao) {
        Date today = new Date();
        if (today.after(dataAdmissao)) {
            System.out.println("Erro: A data de admissao nao pode ser posterior a hoje.");
        } else {
            this.dataAdmissao = dataAdmissao;
        }

    }

    public Double getSalario() {
        return salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setId() {
        Funcionario.id = id++;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getId() {
        return id++;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    // Adicione o método void tirarFerias(),
    // cujas instruções internas imprimem uma
    // mensagem informando que o funcionário irá
    // tirar férias de 30 dias
    public void tirarFerias() {
        System.out.println("O Funcionario " + this.nome + "de ID: " + Funcionario.id + "tirará férias de 30 dias");
    }

    /*
     * Adicione o método void tirarFerias(int dias),
     * cujas instruções internas imprimem uma mensagem
     * informando que o funcionário irá tirar a quantidade de dias
     * informada de férias
     */
    public void tirarFerias(int dias) {
        System.out.println(
                "O Funcionario " + this.nome + "de ID: " + Funcionario.id + " tirará férias de " + dias + " dias");
    }
}
