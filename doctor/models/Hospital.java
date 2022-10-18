package models;

public class Hospital {
    private Long hospitalId;
    protected String nome;
    protected String endereco;

    public Hospital() {
    }

    public Hospital(Long hospitalId, String nome, String endereco) {
        super();
        this.hospitalId = hospitalId;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long gethospitalId() {
        return hospitalId;
    }

    public void sethospitalId(Long hospitalId) {
        this.hospitalId = ++hospitalId;
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

    @Override
    public String toString() {
        return String.format("\nHospital: %d \t Nome: %s \t Endereço: %s", this.gethospitalId(), this.getNome(),
                this.getEndereco());
    }

}
