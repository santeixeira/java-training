package bank.models.entities;

public class Account {
    private String name;
    private Integer number;
    private Double balance;
    private Double withDrawLimit;

    public Account() {

    }

    public Account(String name, Integer number, Double balance, Double withDrawLimit) {
        
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }
}
