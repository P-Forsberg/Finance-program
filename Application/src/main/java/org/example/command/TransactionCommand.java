package org.example.command;

import org.example.Main;
import org.example.saveToFile.Bank;
import org.example.saveToFile.FileBankManager;
import org.example.saveToFile.IBankManager;
// import date:

import java.util.Scanner;

public class TransactionCommand extends Command{
private IBankManager iBankManager;

    public TransactionCommand(Main main){
        super("Transaction", "Register a deposite or withdrawal", main);
        this.iBankManager = new FileBankManager();
}

@Override
    public void execute(String[] commandArgs) {
    if (commandArgs.length != 1){
        throw new IllegalArgumentException("Use: create-bank<title>");
    }

        String bankName = commandArgs[0];
        Bank bank = new Bank();
        bank.title = bankName;

        Scanner scanner = new Scanner(System.in);

    System.out.println("Deposite or Withdrawal");
    bank.title = scanner.nextLine();

    System.out.println("Date: ");
    bank.date = scanner.nextLine();

    System.out.println("What kind of transfer: ");
    bank.description = scanner.nextLine();

    System.out.println("Enter your amount: ");
    bank.currency = scanner.nextInt();
    scanner.nextLine();

    try{
        getiBankManager().save(bank);
        System.out.println("Saved bankinfo '" + bank.title + "'.");
    } catch (Exception exception){
        exception.printStackTrace();
        System.out.println("Couldn't save it.");
    }

    }

    public IBankManager getiBankManager() {
        return iBankManager;
    }
}
