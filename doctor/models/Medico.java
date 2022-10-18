package models;

public class Medico extends Pessoa {
    private Long medicoId;
    private String crm;
    private Double salario;
    private String especializacao;
    private Long pessoaId;

    public Medico() {
    }

    public Medico(String crm, Double salario, String especializacao) {
        this.crm = crm;
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
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

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public void darPlantao() {
        System.out.println(this.getNome() + " dá plantao.");
    }

    @Override
    public String toString() {
        return String.format("Medico: %d\tCRM: %s\tEspecializacao: %s", this.medicoId, this.crm,
                this.especializacao);
    }

}
