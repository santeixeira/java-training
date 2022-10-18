package models;

public class Paciente extends Pessoa {
    private Long pacienteId;
    protected String doenca;
    protected String medicacao;
    private Long pessoaId;

    public Paciente() {}

    public Paciente(Long pacienteId, String doenca, String medicacao) {
        this.pacienteId = pacienteId;
        this.doenca = doenca;
        this.medicacao = medicacao;
    }

    public Long getpacienteId() {
        return pacienteId;
    }

    public void setId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return String.format("O paciente %d, foi diagnosticado com %s, necessita de %s", this.pacienteId, this.doenca,
                this.medicacao);
    }
}
