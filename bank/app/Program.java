package bank.app;

import java.util.Locale;
import java.util.Scanner;

import bank.models.entities.Account;
import bank.models.entities.Withdraw;
import bank.models.exceptions.AccountException;

public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        System.out.print("Account number: ");
        int number = sc.nextInt();

        System.out.print("User name: ");
        sc.nextLine();
        String name = sc.nextLine();
        
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        
        System.out.print("Withdraw limit: ");
        double withDrawLimit = sc.nextDouble();
        
        System.out.print("Enter amount for withdraw: ");
        double withDraw = sc.nextDouble();

        Account acc = new Account(name, number, balance, withDrawLimit);
        Withdraw wd = new Withdraw(name, number, balance, withDrawLimit, withDraw);
        
        

        try {
            wd.validate(withDraw);
            System.out.println("Number: " + acc.getNumber() +
            "   Name: " + acc.getName());
            System.out.println("Initial balance: " + acc.getBalance() +
            "   Withdraw Limit " + acc.getWithDrawLimit());

            System.out.println("Amount for withdraw: " + wd.getWithdraw() + 
            "   New Balance: " + wd.withDraw(balance));
        }

        catch (AccountException e) {
            System.out.println(e.getMessage());
        }
        

        sc.close();
    }

    

}