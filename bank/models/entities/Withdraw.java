package bank.models.entities;

import bank.models.exceptions.AccountException;

public class Withdraw extends Account{
    private double withdraw;
    
    public Withdraw() {

    }

    public Withdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public Withdraw(String name, Integer number, Double balance, Double withDrawLimit, double withdraw) {
        super(name, number, balance, withDrawLimit);
        this.withdraw = withdraw;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double withDraw(double balance) {
        return balance - withdraw;
    }

    public void validate(double withdraw) throws AccountException{
        
        if (withdraw > getWithDrawLimit()) {
            throw new AccountException("Error withdraw: withdraw must be less then limit");
        }
        if (withdraw > getBalance()) {
            throw new AccountException("Error withdraw: unsufficient amount");
        }
        
    }

}
